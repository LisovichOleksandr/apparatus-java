package ua.lis.mvc4.apparatus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class SentenceStructure implements Sentence {

    private final Pronouns pronouns;
    private final ModalVerbs modal;
    private final VerbAllForm verb;

    @Autowired
    public SentenceStructure(Pronouns pronouns, ModalVerbs modal, VerbAllForm verb){
        this.pronouns = pronouns;
        this.modal = modal;
        this.verb = verb;
    }

    @Override
    public String getSentence() {
        return  pronouns.getWord() + ' ' + modal.getWord() + ' ' + verb.getWord();
    }
}
