package isel.sisinf.model.interfaces;

import isel.sisinf.model.Station;

import java.time.LocalDateTime;

public interface IReplacementOrder {
    public LocalDateTime getDorder();
    public void setDorder(LocalDateTime dorder);

    public LocalDateTime getDreplacement();
    public void setDreplacement(LocalDateTime dreplacement);

    public int getRoccupation();
    public void setRoccupation(int roccupation);

    public Station getStation();
    public void setStation(Station station);
}
