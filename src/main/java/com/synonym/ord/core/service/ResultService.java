package com.synonym.ord.core.service;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.persistence.ResultDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class ResultService {

    private Character letter;
    private int numberOfTrials;
    private int numberOfCorrectAnswers;
    private Player player;

    @Autowired
    @Qualifier("getResultDAO")
    private ResultDAO resultDAO;

    public ResultService(){
        super();
    }

    public void init(final Player player, final Character letter) {
        this.letter = letter;
        this.player = player;
        numberOfTrials = 0;
        numberOfCorrectAnswers = 0;
        final List<Integer> correctAnswerCount = new ArrayList<>();
        final List<Integer> numberToCountList = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            correctAnswerCount.add(0);
            numberToCountList.add(i);
        }
    }

    public int getNumberOfCorrectAnswers() {
        return numberOfCorrectAnswers;
    }

    public int getNumberOfTrials() {
        return numberOfTrials;
    }

    public void addTrial(final Player player, final boolean correctAnswer) {
        numberOfTrials++;
        if (correctAnswer) {
            numberOfCorrectAnswers++;
        }
        this.player = player;
    }

    public void saveFinalResult(){
        resultDAO.addCountResult(player.getId(), letter, LocalDate.now(), getNumberOfTrials(), getNumberOfCorrectAnswers());
    }
}
