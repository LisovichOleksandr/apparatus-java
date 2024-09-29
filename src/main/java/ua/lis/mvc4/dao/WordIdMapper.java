/* Id из таблицы Word */

package ua.lis.mvc4.dao;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WordIdMapper implements RowMapper<int[]> {
    @Override
    public int[] mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        int[] verbId = new int[10];

        verbId[0] = resultSet.getInt("vId1");
        verbId[1] = resultSet.getInt("vId2");
        verbId[2] = resultSet.getInt("vId3");
        verbId[3] = resultSet.getInt("vId4");
        verbId[4] = resultSet.getInt("vId5");
        verbId[5] = resultSet.getInt("vId6");
        verbId[6] = resultSet.getInt("vId7");
        verbId[7] = resultSet.getInt("vId8");
        verbId[8] = resultSet.getInt("vId9");
        verbId[9] = resultSet.getInt("vId10");

        return verbId;
    }
}
