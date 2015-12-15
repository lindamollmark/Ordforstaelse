package com.mathhelper.math.core;

import static org.junit.Assert.*;

import java.util.List;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mathhelper.math.core.model.Count;
import com.mathhelper.math.core.model.Player;

@RunWith(PowerMockRunner.class)
@PrepareForTest ({Count.class})
public class CountTest_correctAnswerCount {


	private Count countClass;
	private int chartToCount = 3;
	private double randomNumber = 0.5;
	private int randomNumberToCount = (int)(randomNumber*11);
	private String numberToCount;
	private Player player = new Player("Roger");
	
	@Before
	public void before(){
		countClass = new Count(chartToCount, player);
		// Mocking Math.random()
		PowerMock.mockStatic(Math.class);
		EasyMock.expect((Math.random()*11)).andReturn(randomNumber).anyTimes();
		PowerMock.replay(Math.class);
		numberToCount = countClass.numberToCount();
	}
	@Test
	public void shouldCalculateNumberOfCorrectAnswer_whenNeverAnswerd() throws Exception {
		List<Integer> list = countClass.getCorrectAnswerCount();
		int numberOfCorrectAnswer = list.get(randomNumberToCount);
		assertEquals(0, numberOfCorrectAnswer);
	}
	
	@Test
	public void shouldCalculateNumberOfCorrectAnswer_whenOneAnswerd() throws Exception {
		countClass.correctAnswer(15);
		List<Integer> list = countClass.getCorrectAnswerCount();
		int numberOfCorrectAnswer = list.get(randomNumberToCount);
		assertEquals(1, numberOfCorrectAnswer);
	}
	@Test
	public void shouldCalculateNumberOfCorrectAnswer_whenTwoAnswerd() throws Exception {
		countClass.correctAnswer(15);
		countClass.correctAnswer(15);		
		List<Integer> list = countClass.getCorrectAnswerCount();
		int numberOfCorrectAnswer = list.get(randomNumberToCount);
		assertEquals(2, numberOfCorrectAnswer);
	}

	@Test
	public void shouldCalculateNumberOfCorrectAnswer_whenTwoAnswerdButOnlyOneCorrect() throws Exception {
		countClass.correctAnswer(15);
		countClass.correctAnswer(19);		
		List<Integer> list = countClass.getCorrectAnswerCount();
		int numberOfCorrectAnswer = list.get(randomNumberToCount);
		assertEquals(1, numberOfCorrectAnswer);
	}

}
