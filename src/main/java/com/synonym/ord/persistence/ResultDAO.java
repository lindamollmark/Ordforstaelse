package com.synonym.ord.persistence;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Result;

import java.util.List;

public interface ResultDAO {

    public void addCountResult(int id, Character letter, int numberOfTrials, int numberOfCorrectAnswers);
    public List<Result> getCount(Player player);
}
