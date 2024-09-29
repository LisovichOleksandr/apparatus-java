package ua.lis.mvc4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.lis.mvc4.models.Person;

import java.util.List;

/*  Для учебного наглядного примера, роботы с АПИ БД,
закомментированный код с пояснением будет вынесен, в конец файла
*/

@Component
public class PersonDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index(){
        /* Запрос с помощью jdbcTemplate
        * 1(арг) -- sql запрос
        * 2(арг) -- Указать РОУМАПЕР
        * РОУМАПЕР - это такой объект который отображает строки из таблицы в нашей сущности,
        * т.е каждую строку полученную из таблицы он отобразит в объект класса Person,
        * этот РОУМАПЕР мы должны реализовать сами
        *
        * BeanPropertyRowMapper -- 1(арг) - класс для перевода строк таблицы
        * */

        return jdbcTemplate.query("SELECT * FROM Person", new PersonMapper() {
        });
    }

// prepared -- готовый
    public Person show(int id){
        /* В jdbcTemplate всегда по умолчанию используется prepareStatement
        * 2(арг) -- значения для всех ???? в запросе
        * .stream() -- лямбда выражение
        * .stream().findAny().orElse(null); -- если есть хоть один объект то он будет возвращен,
        * если нет то null
        * */
        Person person = jdbcTemplate.query("SELECT * FROM Person WHERE id=?", new Object[]{id},
                new PersonMapper()).stream().findAny().orElse(null);

        return person;
    }

    public void save(Person person){
        jdbcTemplate.update("INSERT INTO Person (namelogin, age, email) VALUES(?,?,?)", person.getNamelogin(),
             person.getAge(), person.getEmail());
    }

    public void update(int id, Person updatedPerson){
        jdbcTemplate.update("UPDATE Person SET namelogin=?, age=?, email=? WHERE id=?",
                updatedPerson.getNamelogin(), updatedPerson.getAge(), updatedPerson.getEmail(), id);
    }

    public void delete(int id){
        jdbcTemplate.update("DELETE FROM Person WHERE id=?", id);
        }
    }


/*  *****************
*
*********ОБЫЧНЫЕ ЗАПРОСЫ УР1
        // Чтобы подключиться БД необходимо указать URL, name, password
    //обычно эти данные находятся в отдельном файле properties


        private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
        private static final String USERNAME = "postgres";
        private static final String PASSWORD = "entity";

       //  Создать соединение к БД
        private static Connection connection;

        static {
            // подгрузить класс с JDBC драйвером
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            // подключиться
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        *
        * public List<Person> index(){
        List<Person> people = new ArrayList<>();

        // Statement - объект который содержит в себе SQL запрос к БД
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            // Ответ помещаем в ResultSet - ето объект который инкапсулирует результат выполнения запроса к БД
            ResultSet resultSet = statement.executeQuery(SQL); // Выполнить запрос к БД.
            // Дальше прийдется вручную пройтись по строкам из обїекта resultSet
            while(resultSet.next()){
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name_login"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return people;
    }
    *
    * public Person show(int id){
        // Должен искать в БД по ID
        Person person = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Person WHERE id=?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name_login"));
            person.setEmail(resultSet.getString("email"));
            person.setAge(resultSet.getInt("age"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
    *
    *  public void save(Person person){
      //connection статический и ми через этот единственный connection подключаемся

        try {
            // В prepareStatement уже указываем наш запрос с ??? вместо данных
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO Person (namelogin, age, email) VALUES(?,?,?)");

            preparedStatement.setString(1, person.getNamelogin());
            preparedStatement.setInt(2, person.getAge());
            preparedStatement.setString(3, person.getEmail());

            preparedStatement.executeUpdate(); //Выполнить SQL запрос

            //БОЛЬШЕ В РУЧНУЮ НЕ КОНКАТЕНИРУЕМ SQL ЗАПРОc
            //sql exception - который каждый раз нужно обрабатывать try catch
//            Statement statement = connection.createStatement();
            // 1 - так делать очень не удобно, 2- Большая вероятность ошибок, 3- могут возникать SQL инъекции.
            //String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
              //      "'," + person.getAge() + ",'" + person.getEmail() + "')";
//            String SQL = String.format("INSERT INTO Person (name_login, age, email) VALUES('%s',%d,'%s')"
//                    , person.getName(), person.getAge(), person.getEmail());
            //Выполним этот запрос, executeUpdate() - Для изменения данных БД
//            statement.executeUpdate(SQL);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    *
    *
    *  public void update(int id, Person updatedPerson){
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("UPDATE Person SET namelogin=?, age=?, email=? WHERE id=?");
            preparedStatement.setString(1, updatedPerson.getNamelogin());
            preparedStatement.setInt(2, updatedPerson.getAge());
            preparedStatement.setString(3, updatedPerson.getEmail());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
        *
        *  public void delete(int id){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM Person WHERE id=?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        // removeIf() - удаляет по предикату, с помощью лямбда выражение описываем условие, и при true, удаляется
//        people.removeIf(p -> p.getId() == id);
        *
       */