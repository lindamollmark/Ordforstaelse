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

	
	public PlayerService() {
		super();
	}

	public PlayerService(PlayerDAO playDAO) {
		dao = playDAO;
	}

	public Player addPlayer(Player player) {
		Player excisting = getPlayer(player);
		if(excisting == null){
		dao.addPlayer(player);
		excisting =  getPlayer(player);
		}
		else{
			dao.updatePlayer(excisting);
		}
		return excisting;
	}

	private Player getPlayer(Player player) {
		Player excisting = dao.getPlayer(player.getName());
		return excisting;
	}
}
