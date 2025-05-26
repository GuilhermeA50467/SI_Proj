package isel.sisinf.model;


import java.time.LocalDateTime;
import java.util.Objects;


public class Scooter {


    private int id;


    private double weight;


    private double maxvelocity;


    private int battery;


    private ScooterModel model;


    private LocalDateTime version;

    public Scooter() {}

    public Scooter(int id, double weight, double maxvelocity, int battery, ScooterModel model, LocalDateTime version) {
        this.id = id;
        this.weight = weight;
        this.maxvelocity = maxvelocity;
        this.battery = battery;
        this.model = model;
        this.version = version;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getMaxvelocity() { return maxvelocity; }
    public void setMaxvelocity(double maxvelocity) { this.maxvelocity = maxvelocity; }

    public int getBattery() { return battery; }
    public void setBattery(int battery) { this.battery = battery; }

    public ScooterModel getModel() { return model; }
    public void setModel(ScooterModel model) { this.model = model; }

    public LocalDateTime getVersion() { return version; }
    public void setVersion(LocalDateTime version) { this.version = version; }

    @Override
    public String toString() {
        return "Scooter [id=" + id + ", weight=" + weight + ", maxvelocity=" + maxvelocity + ", battery=" + battery
                + ", model=" + model + ", version=" + version + "]";
    }

    @Override
    public int hashCode() { return Objects.hash(id); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Scooter other = (Scooter) obj;
        return id == other.id;
    }
}
