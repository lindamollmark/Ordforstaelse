package com.synonym.ord.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Scope("session")
@SessionAttributes("player")
public class HomeController {


    private Player player;
    @Autowired
    private PlayerService service;

    public HomeController() {
        super();
    }

    public HomeController(PlayerService ps) {
        service = ps;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, SessionStatus session) {
        session.setComplete();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime ldate = LocalDateTime.now();
        String date = ldate.format(formatter);

        model.addAttribute("serverTime", date);

        return "home";
    }

    @RequestMapping(value = "/gameSite", method = RequestMethod.GET)
    public String gameSite(Model model) {
        @SuppressWarnings("rawtypes")
        Map modelMap = model.asMap();
        @SuppressWarnings("unused")
        Player player = (Player) modelMap.get("player");
        return "gameSite";
    }

    @RequestMapping(value = "/gameSite", method = RequestMethod.POST)
    public String gameSite(@RequestParam(value = "name") String name, Model model, HttpServletRequest request) {
        player = new Player(name);
        model.addAttribute("playerName", player.getName());
        Player created = service.addPlayer(player);
        model.addAttribute(created);
        request.getSession().setAttribute("player", created);
        return "gameSite";
    }

}
