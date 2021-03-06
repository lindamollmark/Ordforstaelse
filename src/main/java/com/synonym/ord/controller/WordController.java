package com.synonym.ord.controller;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Result;
import com.synonym.ord.core.model.Word;
import com.synonym.ord.core.service.PlayerService;
import com.synonym.ord.core.service.ResultService;
import com.synonym.ord.core.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("gameSite")
@SessionAttributes("player")
public class WordController {

    @Autowired
    private WordService wordService;
    @Autowired
    private PlayerService playerService;
    @Autowired
    private ResultService resultService;

    @RequestMapping(value = "/count", method = RequestMethod.POST)
    public String chooseLetter(@RequestParam(value = "letter") String letter, Model model, HttpServletRequest request) {
        List<Word> words = wordService.getWordsFromLetter(letter);
        Player player = getPlayerFromModel(model);
        model.addAttribute("words", words);
        resultService.init(player, letter.charAt(0));
        model.addAttribute("playerName", player.getName());
        request.getSession().setAttribute("words", words);
        model.addAttribute(resultService);
        getResultlist(model, player);
        return "count";
    }

    private void getResultlist(Model model, Player player) {
        List<Result> resultList = playerService.getResultList(player);
        model.addAttribute("resultlist", resultList);
    }

    private Player getPlayerFromModel(Model model) {
        @SuppressWarnings("rawtypes")
        Map modelMap = model.asMap();
        return (Player) modelMap.get("player");
    }


    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String compareAnswer(HttpServletRequest request, Model model) throws UnsupportedEncodingException {
        Player player = getPlayerFromModel(model);

        request.setCharacterEncoding("UTF-8");
        String answer = request.getParameter("answer").replace("\n", "").replace("\r", "");
        String id = request.getParameter("id");
        Word wordFromId = wordService.getWordFromId(id);
        Object words = request.getSession().getAttribute("words");
        List<Word> wordList = (ArrayList) words;

        boolean isAnswer = false;
        Integer index = null;
        if (wordFromId.getMeaning().equalsIgnoreCase(answer)) {
            isAnswer = true;
            for (int i = 0; i < wordList.size(); i++) {
                if (wordList.get(i).getId() == Integer.parseInt(id)) {
                    index = i;
                    break;
                }
            }
            if (index != null) {
                wordList.remove(index.intValue());
            }
            if (wordList.isEmpty()) {
                resultService.addTrial(player, true);
                resultService.saveFinalResult();
                getResultlist(model, player);
                return "goal";
            }


        }
        resultService.addTrial(player, isAnswer);
        model.addAttribute(resultService);
        if (!isAnswer) {
            wordService.addWordTrial(wordFromId);
            Collections.shuffle(wordList);
        }
        model.addAttribute("words", wordList);
        model.addAttribute("resultAnswer", isAnswer ? "Rätt!" : "Fel ordet " + wordFromId.getWord() +
                " betyder " + wordFromId.getMeaning() + ". Du skrev " + answer);
        request.getSession().setAttribute("words", wordList);
        getResultlist(model, player);

        return "count";

    }
}


