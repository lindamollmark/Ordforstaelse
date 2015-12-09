package com.mathhelper.math.core;

import java.util.ArrayList;
import java.util.List;

public class Count {
	
	private int chartNumber;
	private int numberOfTrials;
	private int randomNumber;
	private List<Integer> correctAnswerCount;
	private List<Integer> numberToCount;
	
	public Count(int chartNumber) {
		this.chartNumber = chartNumber;
		correctAnswerCount = new ArrayList<>();
		numberToCount = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			correctAnswerCount.add(0);
			numberToCount.add(i);	
		}
	}

	public int getChartNumber() {
		return chartNumber;
	}
		
	public List<Integer> getCorrectAnswerCount() {
		return correctAnswerCount;
	}

	public int calculateAnswer() {
		int answer = chartNumber * randomNumber;
		return answer;
	}

	public void setChartNumber(int chartNumber) {
		this.chartNumber = chartNumber;
	}

	public String numberToCount() {
		randomNumber = (int) (Math.random()*numberToCount.size());
		int numberOfCorrectAnswer = correctAnswerCount.get(randomNumber);
		if(numberOfCorrectAnswer == 3){
			randomNumber = (randomNumber+1);
		}
		String numberToCount = chartNumber + " * " + randomNumber + " = ";
		return numberToCount;
	}

	public Boolean correctAnswer(int answer) {
		numberOfTrials++;
		if(calculateAnswer()==answer){
			int numberOfTimes = correctAnswerCount.get(randomNumber);
			correctAnswerCount.set(randomNumber, numberOfTimes+1);
			if (numberOfTimes <= 2) {
				for (int i = 0; i < numberToCount.size(); i++) {
					if(numberToCount.get(i)== randomNumber){
						numberToCount.remove(i);
					}
					
				}
				
				
			}
			return true;
		}
		return false;
	}

	public int getNumberOfTrials() {
		return numberOfTrials;
	}
	

		
}
