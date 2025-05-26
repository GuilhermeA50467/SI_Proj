package isel.sisinf.model;


import java.util.Objects;


public class ScooterModel {


    private int number;


    private String designation;


    private int autonomy;

    // Constructors
    public ScooterModel() {}

    public ScooterModel(int number, String designation, int autonomy) {
        this.number = number;
        this.designation = designation;
        this.autonomy = autonomy;
    }

    // Getters and setters
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public String getDesignation() { return designation; }
    public void setDesignation(String designation) { this.designation = designation; }

    public int getAutonomy() { return autonomy; }
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
