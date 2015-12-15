package com.mathhelper.math;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mathhelper.math.core.model.Player;

import java.lang.management.PlatformLoggingMXBean;

@Repository
public class PlayerDAOImpl implements PlayerDAO {

	private JdbcTemplate jdbcTemplate;

	public PlayerDAOImpl(){}

	public PlayerDAOImpl(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addPlayer(Player player) {
		String sql = "INSERT INTO player (name) VALUES(?)";
		jdbcTemplate.update(sql, player.getName());
	}

	@Override
	public Player getPlayer(String string) {
		// TODO Auto-generated method stub
		return null;
	}

}
