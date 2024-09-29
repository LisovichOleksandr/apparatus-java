package ua.lis.mvc4.models;

import ua.lis.mvc4.apparatus.FormVerb;
import ua.lis.mvc4.apparatus.ModalVerbs;
import ua.lis.mvc4.apparatus.Pronouns;

import java.util.List;

public class ApparatusModel {
    private List<FormVerb> verbs;
    private final ModalVerbs modalVerbs;
    private final Pronouns pronouns;

    public ApparatusModel() {
        this.modalVerbs = new ModalVerbs();
        this.pronouns = new Pronouns();
    }

    public void setVerbs(List<FormVerb> verbs) {
        this.verbs = verbs;
    }

    public void setPronouns(String pronouns) {
        this.pronouns.setWord(pronouns);
    }

    public String getSentenceStructure() {
        int rand = (int) (Math.random() * 10) % 3;

        if (rand == 0)
            return pronouns.getWord() + " " + verbs.get((int) (Math.random() * 10) % verbs.size()).getInfinitive();
        else if (rand == 1)
            return pronouns.getWord() + " " + modalVerbs.getWord() + " "
                    + verbs.get((int) (Math.random() * 10) % verbs.size()).getInfinitive();
        return pronouns.getWord() + " " + verbs.get((int) (Math.random() * 10) % verbs.size()).getInfinitive() + " "
                + verbs.get((int) (Math.random() * 10) % verbs.size()).getInfinitive();
    }
}