package ua.lis.mvc4.apparatus;

public class FormVerb {
    private int id;
    private String nameUa;
    private String infinitive;
    private String pastSimple;
    private String pastParticiple;
    private String ing;

    public FormVerb(){}

    public FormVerb(String nameUa, String infinitive, String pastSimple, String pastParticiple, String ing) {
        this.nameUa = nameUa;
        this.infinitive = infinitive;
        this.pastSimple = pastSimple;
        this.pastParticiple = pastParticiple;
        this.ing = ing;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameUa() {
        return nameUa;
    }

    public void setNameUa(String nameUa) {
        this.nameUa = nameUa;
    }

    public String getInfinitive() {
        return infinitive;
    }

    public void setInfinitive(String infinitive) {
        this.infinitive = infinitive;
    }

    public String getPastSimple() {
        return pastSimple;
    }

    public void setPastSimple(String pastSimple) {
        this.pastSimple = pastSimple;
    }

    public String getPastParticiple() {
        return pastParticiple;
    }

    public void setPastParticiple(String pastParticiple) {
        this.pastParticiple = pastParticiple;
    }

    public String getIng() {
        return ing;
    }

    public void setIng(String ing) {
        this.ing = ing;
    }

    public String getAllFormVerb(){
        return getPastSimple().equals(getPastParticiple())
                ? getNameUa() + " - " + getInfinitive() + " - " + getPastSimple()+ " - " + getIng()
                : getNameUa() + " - " + getInfinitive() + " - " + getPastSimple() + " - " +getPastParticiple() +
                " " + getIng();
    }
}
