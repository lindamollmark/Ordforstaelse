package com.synonym.ord.persistence;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Result;

import java.time.LocalDateTime;
import java.util.List;

public interface ResultDAO {

    void addCountResult(final int id, final Character letter, final LocalDateTime date, final int numberOfTrials, final int numberOfCorrectAnswers);

    List<Result> getCount(final Player player);
}
