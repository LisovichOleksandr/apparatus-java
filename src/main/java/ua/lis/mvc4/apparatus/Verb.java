/* Неполный класс с возможным дальнейшим удалением */

package ua.lis.mvc4.apparatus;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class Verb implements Word{
    private List<String> verbDb;

    public Verb(){
        verbDb = new ArrayList<>();
        verbDb.add("invoke"); // призывать
        verbDb.add("knit");  //  вязать
        verbDb.add("embrace");  //  обнимать
        verbDb.add("bear");  //  нести
    }


    @Override
    public void setWord(String s) {
        verbDb.add(s);
    }

    @Override
    public String getWord() {
        return verbDb.get((int)(Math.random()*100)%verbDb.size());
    }

    @Override
    public void getRandomSample() {

    }

}
