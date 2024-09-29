package ua.lis.mvc4.apparatus;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class VerbAllForm implements Word{

    public ArrayList<FormVerb> dbVerbs;

//    @Autowired
    public VerbAllForm() {
        dbVerbs = new ArrayList<FormVerb>();
        FormVerb v1 = new FormVerb("бежать", "run", "ran", "run", "running");
        FormVerb v2 = new FormVerb("ходить", "walk", "walked", "walked", "walking");
        FormVerb v3 = new FormVerb("кататься", "ride", "rode", "ridden", "riding");
        dbVerbs.add(v1);
        dbVerbs.add(v2);
        dbVerbs.add(v3);
    }

        /* FD(future delete) -- метод с меткой для удаления */
    public void setVerb(){
        FormVerb v1 = new FormVerb("бежать", "run", "ran", "run", "running");
        FormVerb v2 = new FormVerb("ходить", "walk", "walked", "walked", "walking");
        FormVerb v3 = new FormVerb("кататься", "ride", "rode", "ridden", "riding");
        dbVerbs.add(v1);
        dbVerbs.add(v2);
        dbVerbs.add(v3);
    }

    public void setDbVerbs(ArrayList<FormVerb> dbVerbs){
        this.dbVerbs.addAll(dbVerbs);
    }

    @Override
    public void setWord(String s) {

    }

    @Override
    public String getWord() {
        return dbVerbs.get((int)(Math.random()*100)%dbVerbs.size()).infinitive;
    }

    @Override
    public void getRandomSample() {

    }
}
