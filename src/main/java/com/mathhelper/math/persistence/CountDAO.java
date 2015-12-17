package com.mathhelper.math.persistence;

import java.util.List;

import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.core.model.Result;

public interface CountDAO {

	public void addCountResult(int id, int chartNumber, int numberOfTrials, int numberOfCorrectAnswers);
	public List<Result> getCount(Player player);

}
