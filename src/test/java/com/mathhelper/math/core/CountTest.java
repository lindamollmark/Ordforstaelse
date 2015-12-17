package com.mathhelper.math.core;

import static org.junit.Assert.*;

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
public class CountTest {

	private Count countClass;
	private int chartToCount = 3;
	private double randomNumber = 0.5;
	private int randomNumberToCount = (int)(randomNumber*11);
	private String numberToCount;

	@Before
	public void before(){
		countClass = new Count();
		countClass.init(chartToCount, new Player("Tom"));
		// Mocking Math.random()
		PowerMock.mockStatic(Math.class);
		EasyMock.expect((Math.random()*11)).andReturn(randomNumber).anyTimes();
		PowerMock.replay(Math.class);
		numberToCount = countClass.numberToCount();
	}
	@Test
	public void shouldReturnChartNumber() throws Exception {
		int number = countClass.getChartNumber();

		assertEquals(chartToCount, number);
	}

	@Test
	public void shouldReturnNumberToCount() throws Exception {
		assertEquals(chartToCount + " * " + randomNumberToCount + " = " , numberToCount);
	}

	@Test
	public void shouldCalculateTheAnswer() throws Exception {	
		int answer = countClass.calculateAnswer();

		assertEquals((chartToCount*randomNumberToCount), answer);
	}

	@Test
	public void shouldCompareAnswer_correctAnswer() throws Exception {
		int answer = chartToCount*randomNumberToCount;

		Boolean result = countClass.correctAnswer(answer);

		assertTrue(result);
	}
	
	@Test
	public void shouldCompareAnswer_wrongAnswer() throws Exception {
		int answer = 98;
		
		Boolean result = countClass.correctAnswer(answer);

		assertFalse(result);
	}
	
	@Test
	public void shouldCountNumberOfTrials() throws Exception {
		int answer = 98;
		countClass.correctAnswer(answer);
		countClass.correctAnswer(answer);
		countClass.correctAnswer(answer);
		countClass.correctAnswer(answer);
		
		int numberOfTrials = countClass.getNumberOfTrials();

		assertEquals(4, numberOfTrials);
	}
}
