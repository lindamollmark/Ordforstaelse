package com.synonym.ord.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.synonym.ord.core.model.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.synonym.ord.core.service.WordService;
import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Result;
import com.synonym.ord.core.service.PlayerService;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("gameSite")
@SessionAttributes("player")
public class WordController {

    @Autowired
    private WordService wordService;
    @Autowired
    private PlayerService ps;

    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public String chooseLetter(@RequestParam(required = true, value = "letter") String letter, Model model, HttpServletRequest request) {
        List<Word> words = wordService.getWordsFromLetter(letter);
        Player player = getPlayerFromModel(model);
        model.addAttribute("words", words);

        model.addAttribute("playerName", player.getName());
        request.getSession().setAttribute("words", words);
        return "count";
    }

    private void getResultlist(Model model, Player player) {
        List<Result> resultList = ps.getResultList(player);
        model.addAttribute("resultlist", resultList);
    }

    private Player getPlayerFromModel(Model model) {
        @SuppressWarnings("rawtypes")
        Map modelMap = model.asMap();
        Player player = (Player) modelMap.get("player");
        return player;
    }


    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String compareAnswer(HttpServletRequest request, Model model) {
        Player player = getPlayerFromModel(model);

        String answer = request.getParameter("answer").replace("\n", "").replace("\r", "");
        String id = request.getParameter("id");

        Word wordFromId = wordService.getWordFromId(id);
        String correctAnswer = wordFromId.getMeaning();
        Object words = request.getSession().getAttribute("words");
        List<Word> wordList = (ArrayList) words;
        model.addAttribute(wordService);

        if (answer.equals("")) {
            model.addAttribute("words", wordList);
            model.addAttribute("resultAnswer", "Fel");
            request.getSession().setAttribute("words", wordList);
            return "count";
        } else {

            Integer index = null;
            if (correctAnswer.equalsIgnoreCase(answer)) {
                for (int i = 0; i < wordList.size(); i++) {
                    if (wordList.get(i).getId() == Integer.parseInt(id)) {
                        index = i;
                        break;
                    }
                }
                if (index != null){
                    wordList.remove(index.intValue());
                }
                model.addAttribute("words", wordList);
                model.addAttribute("resultAnswer", "Rätt");
                request.getSession().setAttribute("words", wordList);
                return "count";
            }
            Collections.reverse(wordList);
            model.addAttribute("words", wordList);
            model.addAttribute("resultAnswer", "Fel ordet " + wordFromId.getWord() + " betyder " + correctAnswer);
            request.getSession().setAttribute("words", wordList);

            return "count";
        }
    }

//    @RequestMapping(value = "/submit", method = RequestMethod.POST)
//    public String compareAnswer(@RequestParam(value = "answer") String answer, Model model) {
//        Player player = getPlayerFromModel(model);
//        model.addAttribute(wordService);
//
////		if(answer.equals("")){
////			String toCount = words.numberToCount();
////			model.addAttribute("toCount", toCount);
////			return "count";
////		}
////
////		else {
////			Boolean result = words.correctAnswer(Integer.parseInt(answer));
////			if(result==true){
////				model.addAttribute("resultAnswer", "R�tt");
////			}
////			else{
////				model.addAttribute("resultAnswer", "Fel");
////			}
////			getResultlist(model, player);
////			String toCount = words.numberToCount();
////			model.addAttribute("toCount", toCount);
//        return "count";
//
//    }
}


