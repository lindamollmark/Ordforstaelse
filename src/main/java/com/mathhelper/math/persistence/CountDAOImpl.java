package com.mathhelper.math.persistence;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mathhelper.math.core.model.Player;

@Repository
public class CountDAOImpl implements CountDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	

	public CountDAOImpl() {
		super();
	}

	public CountDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addCountResult(int playerId, int chartNumber, int numberOfTrials, int numberOfCorrectAnswers) {
		String sql = "INSERT INTO chartscounted (player, chartsCounted, trials, correct) VALUES(?, ?,?,?)";
		jdbcTemplate.update(sql, playerId, chartNumber, numberOfTrials, numberOfCorrectAnswers);
		
	}

}
