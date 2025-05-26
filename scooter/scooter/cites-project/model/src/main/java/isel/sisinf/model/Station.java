package isel.sisinf.model;


import java.util.Objects;


public class Station {

    private int id;
    private double latitude;
    private double longitude;

    // Constructors
    public Station() {}

    public Station(int id, double latitude, double longitude) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getLatitude() { return latitude; }
    public void setLatitude(double latitude) { this.latitude = latitude; }

    public double getLongitude() { return longitude; }
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
