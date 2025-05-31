package isel.sisinf.model;


import isel.sisinf.model.interfaces.IScooter;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "SCOOTER")
public class Scooter implements IScooter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "weight", nullable = false, precision = 4, scale = 2)
    private BigDecimal weight;

    @Column(name = "maxvelocity", nullable = false, precision = 4, scale = 2)
    private BigDecimal maxVelocity;

    @Column(nullable = false)
    private int battery;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "model", nullable = false)
    private ScooterModel model;

    @Column(name = "version")
    private Timestamp version;

    public Scooter() {}

    public Scooter(BigDecimal weight, BigDecimal maxvelocity, int battery, ScooterModel model, Timestamp version) {
        setWeight(weight);
        setMaxVelocity(maxvelocity);
        setBattery(battery);
        this.model = model;
        this.version = version;
    }

    // Getters and setters
    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public BigDecimal getWeight() { return weight; }

    @Override
    public void setWeight(BigDecimal weight) {
        if (weight.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Weight deve ser positivo.");
        }
        this.weight = weight;
    }

    @Override
    public BigDecimal getMaxVelocity() { return maxVelocity; }

    @Override
    public void setMaxVelocity(BigDecimal maxVelocity) {
        if (maxVelocity.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("maxVelocity deve ser positiva.");
        }
        this.maxVelocity = maxVelocity;
    }
    @Override
    public int getBattery() { return battery; }
    @Override
    public void setBattery(int battery) {
        if(battery <= 0){
            throw new IllegalArgumentException("Battery deve ser positiva");
        }
        this.battery = battery;
    }
    @Override
    public ScooterModel getModel() { return model; }
    @Override
    public void setModel(ScooterModel model) { this.model = model; }
    @Override
    public Timestamp getVersion() { return version; }
    @Override
    public void setVersion(Timestamp version) { this.version = version; }

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
