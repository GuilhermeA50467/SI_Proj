package isel.sisinf.model;

import isel.sisinf.model.interfaces.IScooterModel;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "SCOOTERMODEL")
public class ScooterModel implements IScooterModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private int number;

    @Column(nullable = false,name = "designation")
    private String designation;

    @Column(nullable = false,name = "autonomy")
    private int autonomy;

    // Constructors
    public ScooterModel() {}

    public ScooterModel(int number, String designation, int autonomy) {
        this.number = number;
        this.designation = designation;
        this.autonomy = autonomy;
    }

    // Getters and setters
    @Override
    public int getNumber() { return number; }
    @Override
    public void setNumber(int number) { this.number = number; }
    @Override
    public String getDesignation() { return designation; }
    @Override
    public void setDesignation(String designation) { this.designation = designation; }
    @Override
    public int getAutonomy() { return autonomy; }
    @Override
    public void setAutonomy(int autonomy) { this.autonomy = autonomy; }

    // Utils
    @Override
    public String toString() {
        return "ScooterModel [number=" + number + ", designation=" + designation + ", autonomy=" + autonomy + "]";
    }

    @Override
    public int hashCode() { return Objects.hash(number); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        ScooterModel other = (ScooterModel) obj;
        return number == other.number;
    }
}
