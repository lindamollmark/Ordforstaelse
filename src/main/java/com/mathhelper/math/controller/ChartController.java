package com.mathhelper.math.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mathhelper.math.core.model.Count;
import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.core.model.Result;
import com.mathhelper.math.core.service.PlayerService;

@Controller
@RequestMapping("gameSite")
@SessionAttributes("player")
public class ChartController {

	@Autowired private Count count;
	@Autowired private PlayerService ps;

	@RequestMapping(value="/count", method=RequestMethod.POST)
	public String chooseNumber(@RequestParam(required=true, value="tableNumber") String tabelNumber,  Model model){
		int chartNumber = Integer.parseInt(tabelNumber);
		Player player = getPlayerFromModel(model);
		count.init(chartNumber, player);
		String toCount = count.numberToCount();
		model.addAttribute("toCount", toCount);

		model.addAttribute("playerName", player.getName());
		getResultlist(model, player);
		model.addAttribute(count);
		return "count";
	}
	private void getResultlist(Model model, Player player) {
		List<Result> resultList = ps.getResultList(player);
		model.addAttribute("resultlist",resultList);
	}
	private Player getPlayerFromModel(Model model) {
		@SuppressWarnings("rawtypes")
		Map modelMap = model.asMap();
		Player player = (Player) modelMap.get("player");
		return player;
	}
	@RequestMapping(value="/submit", method=RequestMethod.POST)
	public String correctCount(@RequestParam(value="answer") String answer, Model model) {
		Player player = getPlayerFromModel(model);
		model.addAttribute(count);

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
			getResultlist(model, player);
			String toCount = count.numberToCount();
			model.addAttribute("toCount", toCount);
			return "count";
		}
	}
}


