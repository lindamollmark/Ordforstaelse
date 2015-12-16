package com.mathhelper.math.persistence;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class CountDAOImpl implements CountDAO {
	
	private JdbcTemplate jdbcTemplate;

	public CountDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void addCountResult(int id, int chartNumber, int numberOfTrials, int numberOfCorrectAnswers) {
		// TODO Auto-generated method stub
		
	}

}
