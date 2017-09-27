package com.synonym.ord.persistence;

import com.synonym.ord.core.model.Player;

public interface PlayerDAO {

	public void addPlayer(Player player);
	public Player getPlayer(String string);
	public void updatePlayer(Player player);
}
