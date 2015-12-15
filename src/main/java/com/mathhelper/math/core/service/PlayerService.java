package com.mathhelper.math.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.persistence.PlayerDAO;

@Service
public class PlayerService {

	@Autowired
	@Qualifier("getPlayerDAO")
	private PlayerDAO dao;

	public void addPlayer(Player player) {
		Player foundPlayer = dao.getPlayer(player.getName());
		dao.addPlayer(player);		
	}
}
