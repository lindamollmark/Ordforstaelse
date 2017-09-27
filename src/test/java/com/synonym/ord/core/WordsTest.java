//package com.synonym.ord.core;
//
//import static org.junit.Assert.*;
//
//import org.easymock.EasyMock;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.powermock.api.easymock.PowerMock;
//import org.powermock.core.classloader.annotations.PrepareForTest;
//import org.powermock.modules.junit4.PowerMockRunner;
//
//import com.synonym.ord.core.service.Words;
//import com.synonym.ord.core.model.Player;
//
//@RunWith(PowerMockRunner.class)
//@PrepareForTest ({Words.class})
//public class WordsTest {
//
//	private Words wordsClass;
//	private int chartToCount = 3;
//	private double randomNumber = 0.5;
//	private int randomNumberToCount = (int)(randomNumber*11);
//	private String numberToCount;
//
//	@Before
//	public void before(){
//		wordsClass = new Words();
//		wordsClass.init(chartToCount, new Player("Tom"));
//		// Mocking Math.random()
//		PowerMock.mockStatic(Math.class);
//		EasyMock.expect((Math.random()*11)).andReturn(randomNumber).anyTimes();
//		PowerMock.replay(Math.class);
//		numberToCount = wordsClass.numberToCount();
//	}
//	@Test
//	public void shouldReturnChartNumber() throws Exception {
//		int number = wordsClass.getChartNumber();
//
//		assertEquals(chartToCount, number);
//	}
//
//	@Test
//	public void shouldReturnNumberToCount() throws Exception {
//		assertEquals(chartToCount + " * " + randomNumberToCount + " = " , numberToCount);
//	}
//
//	@Test
//	public void shouldCalculateTheAnswer() throws Exception {
//		int answer = wordsClass.compareAnswer();
//
//		assertEquals((chartToCount*randomNumberToCount), answer);
//	}
//
//	@Test
//	public void shouldCompareAnswer_correctAnswer() throws Exception {
//		int answer = chartToCount*randomNumberToCount;
//
//		Boolean result = wordsClass.correctAnswer(answer);
//
//		assertTrue(result);
//	}
//
//	@Test
//	public void shouldCompareAnswer_wrongAnswer() throws Exception {
//		int answer = 98;
//
//		Boolean result = wordsClass.correctAnswer(answer);
//
//		assertFalse(result);
//	}
//
//	@Test
//	public void shouldCountNumberOfTrials() throws Exception {
//		int answer = 98;
//		wordsClass.correctAnswer(answer);
//		wordsClass.correctAnswer(answer);
//		wordsClass.correctAnswer(answer);
//		wordsClass.correctAnswer(answer);
//
//		int numberOfTrials = wordsClass.getNumberOfTrials();
//
//		assertEquals(4, numberOfTrials);
//	}
//}
