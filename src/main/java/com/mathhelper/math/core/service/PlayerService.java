package com.mathhelper.math.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.core.model.Result;
import com.mathhelper.math.persistence.CountDAO;
import com.mathhelper.math.persistence.PlayerDAO;

@Service
public class PlayerService {

	@Autowired
	@Qualifier("getPlayerDAO")
	private PlayerDAO dao;
	
	@Autowired
	@Qualifier("getCountDAO")
	private CountDAO countDAO;

	
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

	public List<Result> getResultList(Player player) {
		List<Result> resultList = countDAO.getCount(player);
		player.setResultList(resultList);
		return resultList;
	}
}
