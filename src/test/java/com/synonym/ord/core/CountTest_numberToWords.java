//package com.synonym.ord.core;
//
//import static org.junit.Assert.assertEquals;
//
//import org.easymock.EasyMock;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.easymock.PowerMock;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import com.synonym.ord.core.model.Words;
//import com.synonym.ord.core.model.Player;
//
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest ({Words.class})
//public class CountTest_numberToWords {
//
//	private Words wordsClass = new Words();
//	private int chartToCount = 3;
//	private double randomNumber = 0.5;
//	private int randomNumberToCount = (int)(randomNumber*11);
//	private Player player = new Player("Sigrid");
//
//	@Before
//	public void before(){
//		wordsClass.init(chartToCount, player);
//		// Mocking Math.random()
//		PowerMock.mockStatic(Math.class);
//		EasyMock.expect((Math.random()*11)).andReturn(randomNumber).anyTimes();
//		PowerMock.replay(Math.class);
//		wordsClass.numberToCount();
//	}
//
//	@Test
//	public void shouldGiveSameNumberToCountWhenNeverCounted() throws Exception {
//		String numberToCount = chartToCount + " * " + randomNumberToCount + " = ";
//		String returned = wordsClass.numberToCount();
//
//		assertEquals(numberToCount, returned);
//	}
//
//	@Test
//	public void shouldGiveNewNumberToCountWhenTheCorrectAnswerdIsGivenThreeTimes() throws Exception {
//		wordsClass.correctAnswer(15);
//		wordsClass.correctAnswer(15);
//		wordsClass.correctAnswer(15);
//		String numberToCount = chartToCount + " * " + (randomNumberToCount+1) + " = ";
//		String returned = wordsClass.numberToCount();
//
//		assertEquals(numberToCount, returned);
//	}
//}
