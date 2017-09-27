package com.synonym.ord.persistence;

import java.util.List;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Result;
import com.synonym.ord.core.model.Word;

public interface WordDAO {

	public void addCountResult(int id, int chartNumber, int numberOfTrials, int numberOfCorrectAnswers);
	public List<Result> getCount(Player player);

	public List<Word> getWordsFromLetter(String letter);

	public Word getWordFromId(int id);
}
