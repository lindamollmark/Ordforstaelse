package com.synonym.ord.core.model;

import java.util.Date;

public class Result {
	
	private Character letter;
	private int noOfTrials;
	private int noOfCorrectAnswers;
	private int score;


	public Character getLetter() {
		return letter;
	}

	public void setLetter(Character letter) {
		this.letter = letter;
	}

	public int getNoOfTrials() {
		return noOfTrials;
	}

	public void setNoOfTrials(int noOfTrials) {
		this.noOfTrials = noOfTrials;
	}

	public int getNoOfCorrectAnswers() {
		return noOfCorrectAnswers;
	}

	public void setNoOfCorrectAnswers(int noOfCorrectAnswers) {
		this.noOfCorrectAnswers = noOfCorrectAnswers;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getScore() {
		double correct = noOfCorrectAnswers;
		double trials = noOfTrials;
		score = (int)((correct/trials) * 100) ;
		return score;
	}

}
