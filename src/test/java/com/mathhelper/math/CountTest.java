package com.mathhelper.math;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

//@RunWith(MockitoJUnitRunner.class)
@RunWith(PowerMockRunner.class)
@PrepareForTest ({Count.class})
public class CountTest {
	
	private Count countClass;
	private int chartToCount = 3;
	private int randomNumber = 5;
	
	@Before
	public void before(){
		countClass = new Count(chartToCount);
		// Mocking Math.random()
		PowerMock.mockStatic(Math.class);
		EasyMock.expect((int) Math.random()).andReturn(randomNumber).anyTimes();
		PowerMock.replay(Math.class);
	}
	@Test
	public void shouldReturnChartNumber() throws Exception {
		int number = countClass.getChartNumber();
		
		assertEquals(chartToCount, number);
	}
	
	@Test
	public void shouldReturnNumberToCount() throws Exception {
		String numberToCount = countClass.numberToCount();
		assertEquals(chartToCount + " * " + randomNumber + " = " , numberToCount);
	}
	
	@Test
	public void shouldCalculateTheAnswer() throws Exception {		
		
		int answer = countClass.calculateAnswer();
		
		assertEquals(chartToCount*randomNumber, answer);
	}

	@Test
	public void shouldCompareAnswer_correctAnswer() throws Exception {
		int answer = 15;
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
