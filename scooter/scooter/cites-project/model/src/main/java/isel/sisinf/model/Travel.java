package isel.sisinf.model;


import isel.sisinf.model.interfaces.ITravel;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


public class Travel implements ITravel {

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
    @Override
    public LocalDateTime getDinitial() {return dinitial;}
    @Override
    public void setDinitial(LocalDateTime dinitial) {this.dinitial = dinitial;}
    @Override
    public String getComment() {return comment;}
    @Override
    public void setComment(String comment) {this.comment = comment;}
    @Override
    public Integer getEvaluation() {return evaluation;}
    @Override
    public void setEvaluation(Integer evaluation) {this.evaluation = evaluation;}
    @Override
    public LocalDateTime getDfinal() {return dfinal;}
    @Override
    public void setDfinal(LocalDateTime dfinal) {this.dfinal = dfinal;}
    @Override
    public Client getClient() {return client;}
    @Override
    public void setClient(Client client) {this.client = client;}
    @Override
    public Scooter getScooter() {return scooter;}
    @Override
    public void setScooter(Scooter scooter) {this.scooter = scooter;}
    @Override
    public Station getStinitial() {return stinitial; }
    @Override
    public void setStinitial(Station stinitial) {this.stinitial = stinitial;}
    @Override
    public Station getStfinal() {return stfinal;}
    @Override
    public void setStfinal(Station stfinal) {this.stfinal = stfinal;}

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
