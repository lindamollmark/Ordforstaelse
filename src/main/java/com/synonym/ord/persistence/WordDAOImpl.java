package com.synonym.ord.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Result;
import com.synonym.ord.core.model.Word;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class WordDAOImpl implements WordDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public WordDAOImpl() {
		super();
	}

	public WordDAOImpl(DataSource dataSource) {
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
		for (Map<String, Object> row : rows) {
			Result result = new Result((Integer)row.get("chartsCounted"));
        	result.setNoOfTrials((Integer)row.get("trials"));
        	result.setNoOfCorrectAnswers((Integer)row.get("correct"));
        	resultList.add(result);
		}		
		return resultList;
		}

	@Override
	public List<Word> getWordsFromLetter(String letter) {
		String sql ="SELECT * FROM words WHERE letter = '" + letter + "'";
		List<Word> resultList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Word word = new Word();
			word.setId(Integer.parseInt(row.get("id").toString()));
			word.setWord(row.get("word").toString());
			word.setMeaning(row.get("meaning").toString());
			resultList.add(word);
		}
		return resultList;
	}

	@Override
	public Word getWordFromId(int id) {
		Word word = new Word();
		String sql ="SELECT * FROM words WHERE id = '" + id + "'";
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {

			word.setId(Integer.parseInt(row.get("id").toString()));
			word.setWord(row.get("word").toString());
			word.setMeaning(row.get("meaning").toString());
		}
		return word;
	}
}
