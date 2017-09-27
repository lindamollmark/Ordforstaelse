package com.synonym.ord.core.service;

import java.util.List;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.persistence.PlayerDAO;
import com.synonym.ord.core.model.Result;
import com.synonym.ord.persistence.WordDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

	@Autowired
	@Qualifier("getPlayerDAO")
	private PlayerDAO dao;
	
	@Autowired
	@Qualifier("getWordDAO")
	private WordDAO wordDAO;

	
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
		List<Result> resultList = wordDAO.getCount(player);
		player.setResultList(resultList);
		return resultList;
	}
}
