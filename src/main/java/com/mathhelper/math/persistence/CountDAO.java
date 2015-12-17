package com.mathhelper.math.persistence;

import com.mathhelper.math.core.model.Player;

public interface CountDAO {

	public void addCountResult(int id, int chartNumber, int numberOfTrials, int numberOfCorrectAnswers);

}
