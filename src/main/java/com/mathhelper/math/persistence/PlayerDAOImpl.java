package com.mathhelper.math.persistence;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.mathhelper.math.core.model.Player;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	public Player getPlayer(String name) {
		String sql ="SELECT * FROM player WHERE name = '" + name + "'";
		Player thePlayer = jdbcTemplate.query(sql, new ResultSetExtractor<Player>() {
			 
	        @Override
	        public Player extractData(ResultSet rs) throws SQLException,
	                DataAccessException {
	            if (rs.next()) {
	            	Player player = new Player(rs.getString("name"));
	            	player.setId(rs.getInt("id"));
	                return player;
	            }	 
	            return null;
	        }
	    });
		return thePlayer;
	}

	@Override
	public void updatePlayer(Player player) {
		String sql = "UPDATE player SET name=? where id=?";
		jdbcTemplate.update(sql, player.getName(), player.getId());
	}
}
