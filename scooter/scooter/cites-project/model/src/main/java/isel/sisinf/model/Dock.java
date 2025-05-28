package isel.sisinf.model;

import isel.sisinf.model.interfaces.IDock;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "DOCK")
public class Dock implements IDock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private int number;

    @ManyToOne
    @JoinColumn(name = "station", nullable = false)
    private Station station;

    @Column(name = "state", nullable = false, length = 30)
    private String state;

    @OneToOne
    @JoinColumn(name = "scooter")
    private Scooter scooter;

    @Column(name = "version", nullable = true)
    private LocalDateTime version;

    public Dock() {}

    public Dock(Station station, String state, Scooter scooter, LocalDateTime version) {
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
