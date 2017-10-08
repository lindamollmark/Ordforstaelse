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
	public List<Word> getWordsFromLetter(String letter) {
		String sql ="SELECT * FROM words WHERE letter = '" + letter + "'";
		List<Word> resultList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Word word = new Word();
			word.setId(Integer.parseInt(row.get("id").toString()));
			word.setWord(row.get("word").toString());
			word.setMeaning(row.get("meaning").toString());
			word.setLetter((Character)row.get("letter").toString().charAt(0));
			word.setTrial(Integer.parseInt(row.get("trial").toString()));
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
			word.setLetter((Character)row.get("letter").toString().charAt(0));
			word.setTrial(Integer.parseInt(row.get("trial").toString()));
		}
		return word;
	}

	@Override
	public void saveWord(Word word) {
		String sql = "UPDATE words SET trial =" + word.getTrial() + " WHERE id = '" + word.getId() + "'";
		final int update = jdbcTemplate.update(sql);
	}

	@Override
	public List<Word> getRandomWords() {
		String sql ="SELECT * FROM words ORDER BY trial LIMIT 15";
		List<Word> resultList = new ArrayList<>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		for (Map<String, Object> row : rows) {
			Word word = new Word();
			word.setId(Integer.parseInt(row.get("id").toString()));
			word.setWord(row.get("word").toString());
			word.setMeaning(row.get("meaning").toString());
			word.setLetter((Character)row.get("letter").toString().charAt(0));
			word.setTrial(Integer.parseInt(row.get("trial").toString()));
			resultList.add(word);
		}
		return resultList;
	}
}
