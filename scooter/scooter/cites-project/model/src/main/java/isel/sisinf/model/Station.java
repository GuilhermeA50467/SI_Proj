package isel.sisinf.model;


import isel.sisinf.model.interfaces.IStation;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "STATION")
public class Station implements IStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "latitude", nullable = false)
    private double latitude;

    @Column(name = "longitude", nullable = false)
    private double longitude;

    // Constructors
    public Station() {}

    public Station(int id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public double getLatitude() { return latitude; }
    @Override
    public void setLatitude(double latitude) { this.latitude = latitude; }
    @Override
    public double getLongitude() { return longitude; }
    @Override
    public void setLongitude(double longitude) { this.longitude = longitude; }

    // Utils
    @Override
    public String toString() {
        return "Station [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Station other = (Station) obj;
        return id == other.id;
    }
}
