package isel.sisinf.model;


import isel.sisinf.model.interfaces.IScooter;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SCOOTER")
public class Scooter implements IScooter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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

    @Column(nullable = true, name = "version")
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
    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public double getWeight() { return weight; }
    @Override
    public void setWeight(double weight) { this.weight = weight; }
    @Override
    public double getMaxVelocity() { return maxVelocity; }
    @Override
    public void setMaxVelocity(double maxVelocity) { this.maxVelocity = maxVelocity; }
    @Override
    public int getBattery() { return battery; }
    @Override
    public void setBattery(int battery) { this.battery = battery; }
    @Override
    public ScooterModel getModel() { return model; }
    @Override
    public void setModel(ScooterModel model) { this.model = model; }
    @Override
    public LocalDateTime getVersion() { return version; }
    @Override
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
