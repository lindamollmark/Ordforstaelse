package com.mathhelper.math.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.core.service.PlayerService;

/**
 * Handles requests for the application home page.
 */
@Controller
@Scope("session")
@SessionAttributes("player")
public class HomeController {

	public HomeController() {
		super();
	}
	private Player player;

	@Autowired
	private PlayerService service;
	

	public HomeController(PlayerService ps) {
		service = ps;
	}
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
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
		 Player player = (Player) modelMap.get("player");
		 model.addAttribute("playerName", player.getName());
		return "gameSite";
	}
	@RequestMapping(value = "/gameSite", method = RequestMethod.POST)
	public String gameSite(@RequestParam(value="name") String name, Model model, HttpServletRequest request) {
		player = new Player(name);
		request.getSession().setAttribute("player", player); 
		
		Player created = service.addPlayer(player);
		model.addAttribute(created);
		model.addAttribute("playerName", name);
		return "gameSite";
	}

}
