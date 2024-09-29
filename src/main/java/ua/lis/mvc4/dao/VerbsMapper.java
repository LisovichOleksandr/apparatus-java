package ua.lis.mvc4.dao;

import org.springframework.jdbc.core.RowMapper;
import ua.lis.mvc4.apparatus.FormVerb;

import java.sql.ResultSet;
import java.sql.SQLException;

public class VerbsMapper implements RowMapper<FormVerb> {
    @Override
    public FormVerb mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            FormVerb formVerb = new FormVerb();
            formVerb.setInfinitive(resultSet.getString("infinitive"));
            formVerb.setPastSimple(resultSet.getString("pastsimple"));
            formVerb.setPastParticiple(resultSet.getString("pastparticiple"));
            formVerb.setIng(resultSet.getString("ing"));
            formVerb.setNameUa(resultSet.getString("nameua"));

        return formVerb;
    }
}
