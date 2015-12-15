package com.mathhelper.math.controller;

import java.time.LocalDateTime;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.core.service.PlayerService;
import com.mathhelper.math.persistence.PlayerDAO;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private Player player;

	@Autowired
	private PlayerService service;
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {		
		LocalDateTime ldate = LocalDateTime.now();	
		String formattedDate = ldate.toString();

		model.addAttribute("serverTime", formattedDate );

		return "home";
	}
	@RequestMapping(value = "/gameSite", method = RequestMethod.POST)
	public String gameSite(@RequestParam(value="name") String name, Model model) {

		player = new Player(name);
		service.addPlayer(player);
		model.addAttribute(player);
		model.addAttribute("playerName", name);
		return "gameSite";
	}

}
