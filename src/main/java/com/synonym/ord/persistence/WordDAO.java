package com.synonym.ord.persistence;

import java.util.List;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Result;
import com.synonym.ord.core.model.Word;

public interface WordDAO {

	public List<Word> getWordsFromLetter(String letter);

	public Word getWordFromId(int id);
}
