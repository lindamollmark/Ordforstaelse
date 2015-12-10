package com.mathhelper.math;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.api.easymock.annotation.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import com.mathhelper.math.core.model.Count;


@RunWith(PowerMockRunner.class)
@PrepareForTest ({Count.class})
public class CountTest_numberToCount {

	private Count countClass;
	private int chartToCount = 3;
	private double randomNumber = 0.5;
	private int randomNumberToCount = (int)(randomNumber*11);
	
	
	@Before
	public void before(){
		countClass = new Count(chartToCount);
		// Mocking Math.random()
		PowerMock.mockStatic(Math.class);
		EasyMock.expect((Math.random()*11)).andReturn(randomNumber).anyTimes();
		PowerMock.replay(Math.class);
		countClass.numberToCount();
		
	}
	
	@Test
	public void shouldGiveSameNumberToCountWhenNeverCounted() throws Exception {
		String numberToCount = chartToCount + " * " + randomNumberToCount + " = ";
		String returned = countClass.numberToCount();
		
		assertEquals(numberToCount, returned);
	}
	
	@Test
	public void shouldGiveNewNumberToCountWhenTheCorrectAnswerdIsGivenThreeTimes() throws Exception {
		countClass.correctAnswer(15);
		countClass.correctAnswer(15);
		countClass.correctAnswer(15);
		String numberToCount = chartToCount + " * " + (randomNumberToCount+1) + " = ";
		String returned = countClass.numberToCount();
		
		assertEquals(numberToCount, returned);
	}
}
