package isel.sisinf.model;

import isel.sisinf.model.interfaces.IDock;

import java.time.LocalDateTime;
import java.util.Objects;

public class Dock implements IDock {

    private int number;
    private Station station;
    private String state;
    private Scooter scooter;

    private LocalDateTime version;

    public Dock() {}

    public Dock(int number, Station station, String state, Scooter scooter, LocalDateTime version) {
        this.number = number;
        this.station = station;
        this.state = state;
        this.scooter = scooter;
        this.version = version;
    }

    // Getters e setters
    @Override
    public int getNumber() { return number; }
    @Override
    public void setNumber(int number) { this.number = number; }
    @Override
    public Station getStation() { return station; }
    @Override
    public void setStation(Station station) { this.station = station; }
    @Override
    public String getState() { return state; }
    @Override
    public void setState(String state) { this.state = state; }
    @Override
    public Scooter getScooter() { return scooter; }
    @Override
    public void setScooter(Scooter scooter) { this.scooter = scooter; }
    @Override
    public LocalDateTime getVersion() { return version; }
    @Override
    public void setVersion(LocalDateTime version) { this.version = version; }

    @Override
    public String toString() {
        return "Dock [number=" + number + ", station=" + station + ", state=" + state +
               ", scooter=" + scooter + ", version=" + version + "]";
    }

    @Override
    public int hashCode() { return Objects.hash(number); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Dock other = (Dock) obj;
        return number == other.number;
    }
}
