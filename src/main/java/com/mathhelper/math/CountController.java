package com.mathhelper.math;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("gameSite")
public class CountController {
	
	@RequestMapping(value="/count/", method=RequestMethod.POST)
	public String chooseNumber(@RequestParam(required=true, value="tableNumber") String tabelNumber, Model model){
		System.out.println(tabelNumber);

		String toCount = "1x5";
		model.addAttribute("toCount", toCount);
		return "gameSite";
	}
//	@RequestMapping(value="/count/", method=RequestMethod.GET)
//	public String chooseNumber(Model model){
//		System.out.println("kommer in i getMethoden");
//		String toCount = "1x5";
//		model.addAttribute("toCount", toCount);
//		return "gameSite";
//	}
}
