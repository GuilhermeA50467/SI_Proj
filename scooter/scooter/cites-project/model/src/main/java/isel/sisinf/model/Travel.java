package isel.sisinf.model;


import isel.sisinf.model.interfaces.ITravel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TRAVEL")
public class Travel implements ITravel {

    @EmbeddedId
    private TravelId id;

    @Column(name = "comment")
    private String comment;

    @Column(name = "evaluation")
    private Integer evaluation;

    @Column(name = "dfinal")
    private LocalDateTime dfinal;

    @ManyToOne
    @JoinColumn(name = "client", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "scooter", nullable = false)
    private Scooter scooter;

    @ManyToOne
    @JoinColumn(name = "stinitial", nullable = false)
    private Station stinitial;

    @ManyToOne
    @JoinColumn(name = "stfinal")
    private Station stfinal;

    public Travel() {}

    public Travel(LocalDateTime dinitial, String comment, Integer evaluation, LocalDateTime dfinal,
                  Client client, Scooter scooter, Station stinitial, Station stfinal) {
        this.id = new TravelId(dinitial, scooter.getId());
        setComment(comment);
        setEvaluation(evaluation);
        setDfinal(dfinal);
        this.client = client;
        this.scooter = scooter;
        this.stinitial = stinitial;
        this.stfinal = stfinal;
    }

    @Override
    public LocalDateTime getDinitial() {return id.getDinitial();}
    @Override
    public void setDinitial(LocalDateTime dinitial) {
        this.id.setDinitial(dinitial);
        if (dfinal != null && dfinal.isBefore(dinitial)) {
            throw new IllegalArgumentException("dfinal deve ser maior que dinitial");
        }
    }
    @Override
    public String getComment() {return comment;}
    @Override
    public void setComment(String comment) {
        this.comment = comment;
        validateCommentEvaluationConsistency();
    }
    @Override
    public Integer getEvaluation() {return evaluation;}

    @Override
    public void setEvaluation(Integer evaluation) {
        if (evaluation != null && (evaluation < 1 || evaluation > 5)) {
            throw new IllegalArgumentException("evaluation deve estar entre 1 e 5 ou ser null");
        }
        this.evaluation = evaluation;
    }

    @Override
    public LocalDateTime getDfinal() {return dfinal;}

    @Override
    public void setDfinal(LocalDateTime dfinal) {
        if (dfinal != null && dfinal.isBefore(id.getDinitial())) {
            throw new IllegalArgumentException("dfinal deve ser maior que dinitial ou null");
        }
        this.dfinal = dfinal;
    }

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
        return "Travel [dinitial=" + id.getDinitial()  + ", comment=" + comment + ", evaluation=" + evaluation +
               ", dfinal=" + dfinal + ", client=" + client + ", scooter=" + scooter +
               ", stinitial=" + stinitial + ", stfinal=" + stfinal + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Travel other = (Travel) obj;
        return id.equals(other.id);
    }

    private void validateCommentEvaluationConsistency() {
        if ((comment == null && evaluation != null) || (comment != null && evaluation == null)) {
            throw new IllegalArgumentException("comment e evaluation devem ser ambos null ou ambos preenchidos");
        }
    }
}
