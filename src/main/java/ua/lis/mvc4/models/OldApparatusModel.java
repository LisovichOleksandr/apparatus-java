package ua.lis.mvc4.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.lis.mvc4.apparatus.ModalVerbs;
import ua.lis.mvc4.apparatus.Pronouns;
import ua.lis.mvc4.apparatus.SentenceStructure;
import ua.lis.mvc4.apparatus.VerbAllForm;

@Component
public class OldApparatusModel extends SentenceStructure {
    @Autowired
    public OldApparatusModel(Pronouns pronouns, ModalVerbs modal, VerbAllForm verb) {
        super(pronouns, modal, verb);
    }

    @Override
    public String getSentence() {
        return super.getSentence();
    }


}
