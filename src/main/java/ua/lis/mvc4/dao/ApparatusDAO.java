package ua.lis.mvc4.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import ua.lis.mvc4.apparatus.FormVerb;
import ua.lis.mvc4.models.ApparatusModel;

import java.util.List;

@Component
public class ApparatusDAO {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ApparatusDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private List<int[]> getWordId (){
        System.out.println("getWordId start");
        return jdbcTemplate.query("SELECT * FROM word WHERE id=1", new WordIdMapper());
    }

    private List<FormVerb> getVerbsDb(){
        System.out.println("getVerbsDb start");
        int[] id = getWordId().get(0);
        System.out.println("getVerbsDb: id[0] =" + id[0] + " id[9] = " + id[9] );
        return jdbcTemplate.query("SELECT * FROM Verb WHERE id IN (?,?,?,?,?,?,?,?,?,?) LIMIT 10;", new Object[]{id[0], id[1],
                id[2], id[3], id[4], id[5], id[6], id[7], id[8], id[9]}, new VerbsMapper());
    }

    public String getSentence(){
        ApparatusModel apparatusModel = new ApparatusModel();
        apparatusModel.setVerbs(getVerbsDb());
        return apparatusModel.getSentenceStructure();
    }

    public List<FormVerb> getTenVerb(){
        return getVerbsDb();
    }

    public FormVerb getVerb(int id){
        return jdbcTemplate.query("SELECT * FROM Verb WHERE id=?", new Object[]{id}, new VerbsMapper())
                .stream().findAny().orElse(null);
    }

    public void saveVerb(FormVerb formVerb){
        jdbcTemplate.update("INSERT INTO public.verb (infinitive, pastsimple, pastparticiple, ing, nameUa)" +
                        " VALUES (?, ?, ?, ?, ?);", formVerb.getInfinitive(),
                formVerb.getPastSimple(), formVerb.getPastParticiple(), formVerb.getIng(), formVerb.getNameUa());
    }
}

/*
************Запрос ур1***********
* @Component
public class ApparatusDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/first_db";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "entity";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private List<FormVerb> getVerbsDb(){

        List<FormVerb> verbs = new ArrayList<>();

        int[] verbId = new int[10];
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM word WHERE id=?");
            preparedStatement.setInt(1,1);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try {
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("SELECT * FROM Verb WHERE id IN (?,?,?,?,?,?,?,?,?,?) LIMIT 10;");
            preparedStatement1.setInt(1,verbId[0]);
            preparedStatement1.setInt(2,verbId[1]);
            preparedStatement1.setInt(3,verbId[2]);
            preparedStatement1.setInt(4,verbId[3]);
            preparedStatement1.setInt(5,verbId[4]);
            preparedStatement1.setInt(6,verbId[5]);
            preparedStatement1.setInt(7,verbId[6]);
            preparedStatement1.setInt(8,verbId[7]);
            preparedStatement1.setInt(9,verbId[8]);
            preparedStatement1.setInt(10,verbId[9]);

            ResultSet resultSet1 = preparedStatement1.executeQuery();

            while (resultSet1.next()) {
                FormVerb formVerb = new FormVerb();
                formVerb.setInfinitive(resultSet1.getString("infinitive"));
                formVerb.setPastSimple(resultSet1.getString("pastsimple"));
                formVerb.setPastParticiple(resultSet1.getString("pastparticiple"));
                formVerb.setIng(resultSet1.getString("ing"));
                formVerb.setNameUa(resultSet1.getString("nameua"));
                verbs.add(formVerb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return verbs;
    }

    public String getSentence(){
        ApparatusModel apparatusModel = new ApparatusModel();
        apparatusModel.setVerbs(getVerbsDb());
        return apparatusModel.getSentenceStructure();
    }

}
* */