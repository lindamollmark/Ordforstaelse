package com.mathhelper.math.core.model;

import java.util.ArrayList;
import java.util.List;

public class Count {
	
	private int chartNumber;
	private int numberOfTrials;
	private int numberOfCorrectAnswers;
	
	private int randomNumber;
	private List<Integer> correctAnswerCount;
	private List<Integer> numberToCountList;
	
	public Count(int chartNumber) {
		this.chartNumber = chartNumber;
		correctAnswerCount = new ArrayList<>();
		numberToCountList = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			correctAnswerCount.add(0);
			numberToCountList.add(i);	
		}
	}

	public int getChartNumber() {
		return chartNumber;
	}
		
	public List<Integer> getCorrectAnswerCount() {
		return correctAnswerCount;
	}

	public int getNumberOfCorrectAnswers() {
		return numberOfCorrectAnswers;
	}

	public int calculateAnswer() {
		int answer = chartNumber * randomNumber;
		return answer;
	}

	public void setChartNumber(int chartNumber) {
		this.chartNumber = chartNumber;
	}

	public String numberToCount() {
		if (numberToCountList.isEmpty()) {
			return "Du är klar med hela " + chartNumber +" :ans tabell! Bra jobbat!";
		}
		randomNumber();
		String numberToCount = chartNumber + " * " + randomNumber + " = ";
		return numberToCount;
	}

	private void randomNumber() {
		randomNumber = (int) (Math.random()*numberToCountList.size());
		randomNumber = numberToCountList.get(randomNumber);
	}

	public Boolean correctAnswer(int answer) {
		numberOfTrials++;
		if(calculateAnswer()==answer){
			int numberOfTimes = correctAnswerCount.get(randomNumber);
			numberOfCorrectAnswers++;
			correctAnswerCount.set(randomNumber, numberOfTimes+1);
			if (numberOfTimes >= 2) {
				for (int i = 0; i < numberToCountList.size(); i++) {
					if(numberToCountList.get(i)== randomNumber){
						numberToCountList.remove(i);
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
