package isel.sisinf.model;


import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SCOOTER")
public class Scooter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, precision = 4, scale = 2)
    private double weight;

    @Column(nullable = false, precision = 4, scale = 2, name = "maxvelocity")
    private double maxVelocity;

    @Column(nullable = false)
    private int battery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model", nullable = false)
    private ScooterModel model;

    @Column(nullable = false, name = "version")
    private LocalDateTime version;

    public Scooter() {}

    public Scooter(int id, double weight, double maxvelocity, int battery, ScooterModel model, LocalDateTime version) {
        this.id = id;
        this.weight = weight;
        this.maxVelocity = maxvelocity;
        this.battery = battery;
        this.model = model;
        this.version = version;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public double getMaxVelocity() { return maxVelocity; }
    public void setMaxVelocity(double maxVelocity) { this.maxVelocity = maxVelocity; }

    public int getBattery() { return battery; }
    public void setBattery(int battery) { this.battery = battery; }

    public ScooterModel getModel() { return model; }
    public void setModel(ScooterModel model) { this.model = model; }

    public LocalDateTime getVersion() { return version; }

    public void setVersion(LocalDateTime version) { this.version = version; }

    @Override
    public String toString() {
        return String.format("Scooter [id=" + id + ", weight=" + weight + ", maxvelocity=" + maxVelocity + ", battery=" + battery
                + ", model=" + model + ", version=" + version + "]");
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
