package com.synonym.ord.core.service;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.persistence.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    private String word;
    private String meaning;
    private Character letter;
    private int numberOfTrials;
    private int numberOfCorrectAnswers;
    private Player player;
    private List<Integer> correctAnswerCount;
    private List<Integer> numberToCountList;

    @Autowired
    @Qualifier("getResultDAO")
    private ResultDAO resultDAO;

    public ResultService(){
        super();
    }

    public void init(Player player, Character letter) {
        this.letter = letter;
        this.player = player;
        numberOfTrials = 0;
        numberOfCorrectAnswers = 0;
        correctAnswerCount = new ArrayList<>();
        numberToCountList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            correctAnswerCount.add(0);
            numberToCountList.add(i);
        }
    }

    public List<Integer> getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public void addTrial(Player player, Character letter, boolean correctAnswer) {
        numberOfTrials++;
        if (correctAnswer) {
            numberOfCorrectAnswers++;
        }
        this.player = player;
    }

    public void saveFinalResult(){
        resultDAO.addCountResult(player.getId(), letter, getNumberOfTrials(), getNumberOfCorrectAnswers());
    }
}
