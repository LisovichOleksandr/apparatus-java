package ua.lis.mvc4.apparatus;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component()
public class Pronouns implements Word{
    private  ArrayList<String> pronounsDb;

    public Pronouns(){
        pronounsDb = new ArrayList<String>();
        pronounsDb.add("i");
        pronounsDb.add("you");
        pronounsDb.add("they");
        pronounsDb.add("we");
        pronounsDb.add("he");
        pronounsDb.add("she");
    }

    @Override
    public void setWord(String s) {
        pronounsDb.add(s);
    }

    @Override
    public String getWord() {
        return pronounsDb.get((int)(Math.random()*10)%pronounsDb.size());
    }

    @Override
    public void getRandomSample() {

    }
}
