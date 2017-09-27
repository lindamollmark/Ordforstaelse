package com.synonym.ord.core.service;

import java.util.ArrayList;
import java.util.List;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Word;
import com.synonym.ord.persistence.WordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class WordService {

	private String word;
	private String meaning;
	private char letter;
	private int numberOfTrials;
	private int numberOfCorrectAnswers;
	private Player player;
	private int randomNumber;
	private List<Integer> correctAnswerCount;
	private List<Integer> numberToCountList;
	
	@Autowired
	@Qualifier("getWordDAO")
	private WordDAO wordDAO;
	
	public WordService() {
		super();
	}
	
	public void init(char letter, Player player) {
		this.letter = letter;
		this.player = player;
		numberOfTrials = 0;
		numberOfCorrectAnswers = 0;
		correctAnswerCount = new ArrayList<>();
		numberToCountList = new ArrayList<>();
		for (int i = 0; i < 11; i++) {
			correctAnswerCount.add(0);
			numberToCountList.add(i);	
		}
	}

	public List<Integer> getCorrectAnswerCount() {
		return correctAnswerCount;
	}

	public int getNumberOfCorrectAnswers() {
		return numberOfCorrectAnswers;
	}

	public int getNumberOfTrials() {
		return numberOfTrials;
	}

	public List<Word> getWordsFromLetter(String letter) {
		List<Word> words = wordDAO.getWordsFromLetter(letter);
		return words;
	}

	public Word getWordFromId(String id) {
		return wordDAO.getWordFromId(Integer.parseInt(id));
	}
}
