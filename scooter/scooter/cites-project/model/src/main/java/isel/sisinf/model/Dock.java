package isel.sisinf.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Dock {

    private int number;
    private Station station;
    private String state;
    private Scooter scooter; // Pode ser null, por isso Integer antes virou objeto Scooter

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
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public Station getStation() { return station; }
    public void setStation(Station station) { this.station = station; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public Scooter getScooter() { return scooter; }
    public void setScooter(Scooter scooter) { this.scooter = scooter; }

    public LocalDateTime getVersion() { return version; }
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
