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

    @Autowired
    @Qualifier("getWordDAO")
    private WordDAO wordDAO;

    public WordService() {
        super();
    }

    public List<Word> getWordsFromLetter(String letter) {
        List<Word> words = new ArrayList<>();
        if (letter.equals("mix")){
			words = wordDAO.getRandomWords();
		}
		else {
            words = wordDAO.getWordsFromLetter(letter);
        }
        return words;
    }

    public Word getWordFromId(String id) {
        return wordDAO.getWordFromId(Integer.parseInt(id));

    }

    public void addWordTrial(Word word) {
        word.addTrial();
        wordDAO.saveWord(word);

    }

}
