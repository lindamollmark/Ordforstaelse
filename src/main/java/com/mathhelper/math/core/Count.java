package com.mathhelper.math.core;


public class Count {
	
	private int chartNumber;
	private int numberOfTrials;
	private int randomNumber;
	
	public Count(int chartNumber) {
		this.chartNumber = chartNumber;
	}

	public int getChartNumber() {
		return chartNumber;
	}
	
	public int calculateAnswer() {
		int answer = chartNumber * randomNumber;
		return answer;
	}

	public void setChartNumber(int chartNumber) {
		this.chartNumber = chartNumber;
	}

	public String numberToCount() {
		randomNumber = (int) (Math.random()*11);
		String numberToCount = chartNumber + " * " + randomNumber + " = ";
		return numberToCount;
	}

	public Boolean correctAnswer(int answer) {
		numberOfTrials++;
		if(calculateAnswer()==answer){
			return true;
		}
		return false;
	}

	public int getNumberOfTrials() {
		return numberOfTrials;
	}
	

		
}
