package com.synonym.ord.core.model;

import java.time.LocalDateTime;

public class Result {
	
	private Character letter;
	private int noOfTrials;
	private int noOfCorrectAnswers;
	private int score;
    private LocalDateTime resultDate;


	public Character getLetter() {
		return letter;
	}

    public void setLetter(final Character letter) {
		this.letter = letter;
	}

	public int getNoOfTrials() {
		return noOfTrials;
	}

    public void setNoOfTrials(final int noOfTrials) {
		this.noOfTrials = noOfTrials;
	}

	public int getNoOfCorrectAnswers() {
		return noOfCorrectAnswers;
	}

    public void setNoOfCorrectAnswers(final int noOfCorrectAnswers) {
		this.noOfCorrectAnswers = noOfCorrectAnswers;
	}

    public void setScore(final int score) {
		this.score = score;
	}

	public int getScore() {
		double correct = noOfCorrectAnswers;
		double trials = noOfTrials;
		score = (int)((correct/trials) * 100) ;
		return score;
	}

    public LocalDateTime getResultDate() {
        return resultDate;
    }

    public void setResultDate(final LocalDateTime resultDate) {
        this.resultDate = resultDate;
    }
}
