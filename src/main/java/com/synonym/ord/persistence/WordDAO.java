package com.synonym.ord.persistence;

import com.synonym.ord.core.model.Word;

import java.util.List;

public interface WordDAO {

	public List<Word> getWordsFromLetter(String letter);

	public Word getWordFromId(int id);

    public void saveWord(Word word);

	public List<Word> getRandomWords();

    public List<String> getAlternatives();
}
