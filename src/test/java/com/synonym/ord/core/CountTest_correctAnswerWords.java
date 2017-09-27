//package com.synonym.ord.core;
//
//import static org.junit.Assert.*;
//
//import java.util.List;
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
//@RunWith(PowerMockRunner.class)
//@PrepareForTest ({Words.class})
//public class CountTest_correctAnswerWords {
//
//
//	private Words wordsClass;
//	private int chartToCount = 3;
//	private double randomNumber = 0.5;
//	private int randomNumberToCount = (int)(randomNumber*11);
//	private Player player = new Player("Roger");
//
//	@Before
//	public void before(){
//		wordsClass = new Words();
//		wordsClass.init(chartToCount, player);
//		// Mocking Math.random()
//		PowerMock.mockStatic(Math.class);
//		EasyMock.expect((Math.random()*11)).andReturn(randomNumber).anyTimes();
//		PowerMock.replay(Math.class);
//
//		wordsClass.numberToCount();
//	}
//	@Test
//	public void shouldCalculateNumberOfCorrectAnswer_whenNeverAnswerd() throws Exception {
//		List<Integer> list = wordsClass.getCorrectAnswerCount();
//		int numberOfCorrectAnswer = list.get(randomNumberToCount);
//		assertEquals(0, numberOfCorrectAnswer);
//	}
//
//	@Test
//	public void shouldCalculateNumberOfCorrectAnswer_whenOneAnswerd() throws Exception {
//		wordsClass.correctAnswer(15);
//		List<Integer> list = wordsClass.getCorrectAnswerCount();
//		int numberOfCorrectAnswer = list.get(randomNumberToCount);
//		assertEquals(1, numberOfCorrectAnswer);
//	}
//	@Test
//	public void shouldCalculateNumberOfCorrectAnswer_whenTwoAnswerd() throws Exception {
//		wordsClass.correctAnswer(15);
//		wordsClass.correctAnswer(15);
//		List<Integer> list = wordsClass.getCorrectAnswerCount();
//		int numberOfCorrectAnswer = list.get(randomNumberToCount);
//		assertEquals(2, numberOfCorrectAnswer);
//	}
//
//	@Test
//	public void shouldCalculateNumberOfCorrectAnswer_whenTwoAnswerdButOnlyOneCorrect() throws Exception {
//		wordsClass.correctAnswer(15);
//		wordsClass.correctAnswer(19);
//		List<Integer> list = wordsClass.getCorrectAnswerCount();
//		int numberOfCorrectAnswer = list.get(randomNumberToCount);
//		assertEquals(1, numberOfCorrectAnswer);
//	}
//
//}
