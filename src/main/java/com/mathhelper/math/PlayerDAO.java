package com.mathhelper.math;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.mathhelper.math.core.model.Player;

public class PlayerDAO {

	private JdbcTemplate jdbcTemplate;
	 
    public PlayerDAO(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void addPlayer(Player player){
    	String playerName = player.getName();
    	String sql = "INSERT INTO Player (name) VALUES playerName";
    	jdbcTemplate.update(sql);
    }
}
