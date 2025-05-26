package isel.sisinf.model.interfaces;

import isel.sisinf.model.Scooter;
import isel.sisinf.model.Station;

import java.time.LocalDateTime;

public interface IDock {
    public int getNumber();
    public void setNumber(int number);

    public Station getStation();
    public void setStation(Station station);

    public String getState();
    public void setState(String state);

    public Scooter getScooter();
    public void setScooter(Scooter scooter);

    public LocalDateTime getVersion();
    public void setVersion(LocalDateTime version);
}
