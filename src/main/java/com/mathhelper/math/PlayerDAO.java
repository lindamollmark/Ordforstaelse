package com.mathhelper.math;

import com.mathhelper.math.core.model.Player;


public interface PlayerDAO {

	public void addPlayer(Player player);
	public Player getPlayer(String string);

}
