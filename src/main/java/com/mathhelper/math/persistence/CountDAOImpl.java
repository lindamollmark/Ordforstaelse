package com.mathhelper.math.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.mathhelper.math.core.model.Player;
import com.mathhelper.math.core.model.Result;

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

	@Override
	public List<Result> getCount(Player player) {
		String sql ="SELECT * FROM chartscounted WHERE player = '" + player.getId() + "'";
		List<Result> resultList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map row : rows) {
			Result result = new Result((Integer)row.get("chartsCounted"));
        	result.setNoOfTrials((Integer)row.get("trials"));
        	result.setNoOfCorrectAnswers((Integer)row.get("correct"));
        	resultList.add(result);
		}
		
		return resultList;
		}

}
