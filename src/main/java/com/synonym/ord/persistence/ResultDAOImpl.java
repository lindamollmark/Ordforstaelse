package com.synonym.ord.persistence;

import com.synonym.ord.core.model.Player;
import com.synonym.ord.core.model.Result;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ResultDAOImpl implements ResultDAO {

    private JdbcTemplate jdbcTemplate;

    public ResultDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public void addCountResult(final int playerId, final Character letter, final LocalDateTime localDate, final int numberOfTrials, final int numberOfCorrectAnswers) {
        String sql = "INSERT INTO result (player, letter, date, trials, correct) VALUES(?, ?,?,?, ?)";
        jdbcTemplate.update(sql, playerId, letter.toString(), Timestamp.valueOf(localDate), numberOfTrials, numberOfCorrectAnswers);
    }

    @Override
    public List<Result> getCount(Player player) {
        String sql ="SELECT * FROM result WHERE player = '" + player.getId() + "'";
        List<Result> resultList = new ArrayList<>();
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
        for (Map<String, Object> row : rows) {
            Result result = new Result();
            result.setLetter((Character)row.get("letter").toString().charAt(0));
            result.setNoOfTrials((Integer)row.get("trials"));
            result.setNoOfCorrectAnswers((Integer)row.get("correct"));
            final Timestamp date = (Timestamp) row.get("date");
            result.setResultDate(date != null ? date.toLocalDateTime() : LocalDateTime.now().minusMonths(4));
            resultList.add(result);
        }
        return resultList;
    }

}
