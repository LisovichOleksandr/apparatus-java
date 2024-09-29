package ua.lis.mvc4.dao;

import org.springframework.jdbc.core.RowMapper;
import ua.lis.mvc4.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {

    @Override
    public Person mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Person person = new Person();
//  Когда имена в объекте совпадают с именами в БД, можно использовать готовый РОУМАППЕР BeanPropertyRowMapper
        person.setId(resultSet.getInt("id"));
        person.setNamelogin(resultSet.getString("namelogin"));
        person.setEmail(resultSet.getString("email"));
        person.setAge(resultSet.getInt("age"));
        return person;
    }
}
