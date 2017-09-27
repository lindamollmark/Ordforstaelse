package com.synonym.ord.core.model;

public class Result {
	
	private int chart;
	private int noOfTrials;
	private int noOfCorrectAnswers;
	private int score;
	
	public Result(int chart) {
		this.chart = chart;
	}
	public int getChart() {
		return chart;
	}
	public void setChart(int chart) {
		this.chart = chart;
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
	public int getScore() {
		double correct = noOfCorrectAnswers;
		double trials = noOfTrials;
		score = (int)((correct/trials) * 100) ;
		return score;
	}

}
