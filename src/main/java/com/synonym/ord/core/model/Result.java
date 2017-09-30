package com.synonym.ord.core.model;

public class Result {
	
	private char letter;
	private int noOfTrials;
	private int noOfCorrectAnswers;
	private int score;


	public char getLetter() {
		return letter;
	}

	public void setLetter(char letter) {
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
