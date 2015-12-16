package com.mathhelper.math.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mathhelper.math.core.model.Count;
import com.mathhelper.math.core.model.Player;

@Controller
@RequestMapping("gameSite")
@SessionAttributes("player")
public class ChartController {

	private Count count;
	
	@RequestMapping(value="/count", method=RequestMethod.POST)
	public String chooseNumber(@RequestParam(required=true, value="tableNumber") String tabelNumber,  Model model){
		int chartNumber = Integer.parseInt(tabelNumber);
		 Map modelMap = model.asMap();
		 Player player = (Player) modelMap.get("player");
		System.out.println(player.getName());
		
		count = new Count(chartNumber, player);
		String toCount = count.numberToCount();
		model.addAttribute("playerName", player.getName());
		model.addAttribute("toCount", toCount);
		return "count";
	}
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String correctCount(@RequestParam(value="answer") String answer, Model model) {

		if(answer.equals("")){
			String toCount = count.numberToCount();
			model.addAttribute("toCount", toCount);
			return "count";
		}
		
		else {
		Boolean result = count.correctAnswer(Integer.parseInt(answer));
		if(result==true){
			model.addAttribute("resultAnswer", "Rätt");
		}
		else{
			model.addAttribute("resultAnswer", "Fel");
		}

		model.addAttribute("noOfTrials", count.getNumberOfTrials());
		model.addAttribute("noOfCorrectAnswers", count.getNumberOfCorrectAnswers());
		String toCount = count.numberToCount();
		model.addAttribute("toCount", toCount);
		return "count";
		}
	}
	
}
