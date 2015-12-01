package com.mathhelper.math;


public class Count {
	
	private int chartNumber;
	private int numberOfTrials;
	
	public Count(int chartNumber) {
		this.chartNumber = chartNumber;
	}

	public int getChartNumber() {
		return chartNumber;
	}
	
//	public int randomNumber(){
//		int random = (int) (Math.random()*11);
//		return random;
//	}

	public int calculateAnswer() {
		int randomNumber = (int) (Math.random());
		int answer = chartNumber * randomNumber;
		
		return answer;
	}

	public void setChartNumber(int chartNumber) {
		this.chartNumber = chartNumber;
		
	}

	public String numberToCount() {
		String numberToCount = chartNumber + " * " + (int) (Math.random()) + " = ";
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
