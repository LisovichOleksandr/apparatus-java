package ua.lis.mvc4.apparatus;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component()
public class ModalVerbs implements Word{

    public ArrayList<String> modalDb;


    public ModalVerbs(){
        modalDb = new ArrayList<>(6);
        modalDb.add("can");
        modalDb.add("may");
        modalDb.add("mast");
        modalDb.add("will");
        modalDb.add("should");
        modalDb.add("would");
        modalDb.add("have");
    }
    @Override
    public void getRandomSample() {
        System.out.println("random verb");
        System.out.println(modalDb.get((int)(Math.random()*10)%6));
    }

    @Override
    public void setWord(String s) {
        modalDb.add(s);
    }

    @Override
    public String getWord() {
        return modalDb.get((int)(Math.random()*10)%modalDb.size());
    }
}
