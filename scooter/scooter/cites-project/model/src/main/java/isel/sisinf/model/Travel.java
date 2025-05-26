package isel.sisinf.model;


import java.time.LocalDateTime;
import java.util.Objects;


public class Travel {

    private LocalDateTime dinitial;
    private String comment;
    private Integer evaluation;
    private LocalDateTime dfinal;
    private Client client;
    private Scooter scooter;
    private Station stinitial;
    private Station stfinal;

    public Travel() {}

    public Travel(LocalDateTime dinitial, String comment, Integer evaluation, LocalDateTime dfinal,
                  Client client, Scooter scooter, Station stinitial, Station stfinal) {
        this.dinitial = dinitial;
        this.comment = comment;
        this.evaluation = evaluation;
        this.dfinal = dfinal;
        this.client = client;
        this.scooter = scooter;
        this.stinitial = stinitial;
        this.stfinal = stfinal;
    }

    public LocalDateTime getDinitial() {
        return dinitial;
    }

    public void setDinitial(LocalDateTime dinitial) {
        this.dinitial = dinitial;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Integer evaluation) {
        this.evaluation = evaluation;
    }

    public LocalDateTime getDfinal() {
        return dfinal;
    }

    public void setDfinal(LocalDateTime dfinal) {
        this.dfinal = dfinal;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Scooter getScooter() {
        return scooter;
    }

    public void setScooter(Scooter scooter) {
        this.scooter = scooter;
    }

    public Station getStinitial() {
        return stinitial;
    }

    public void setStinitial(Station stinitial) {
        this.stinitial = stinitial;
    }

    public Station getStfinal() {
        return stfinal;
    }

    public void setStfinal(Station stfinal) {
        this.stfinal = stfinal;
    }

    @Override
    public String toString() {
        return "Travel [dinitial=" + dinitial + ", comment=" + comment + ", evaluation=" + evaluation +
               ", dfinal=" + dfinal + ", client=" + client + ", scooter=" + scooter +
               ", stinitial=" + stinitial + ", stfinal=" + stfinal + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(dinitial);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Travel other = (Travel) obj;
        return dinitial.equals(other.dinitial);
    }
}
