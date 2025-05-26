package isel.sisinf.model.interfaces;

import isel.sisinf.model.Client;
import isel.sisinf.model.Scooter;
import isel.sisinf.model.Station;

import java.time.LocalDateTime;

public interface ITravel {
    public LocalDateTime getDinitial();
    public void setDinitial(LocalDateTime dinitial);

    public String getComment() ;
    public void setComment(String comment) ;

    public Integer getEvaluation();
    public void setEvaluation(Integer evaluation);

    public LocalDateTime getDfinal();
    public void setDfinal(LocalDateTime dfinal) ;

    public Client getClient() ;
    public void setClient(Client client) ;

    public Scooter getScooter() ;
    public void setScooter(Scooter scooter) ;

    public Station getStinitial() ;
    public void setStinitial(Station stinitial) ;

    public Station getStfinal() ;
    public void setStfinal(Station stfinal) ;
}
