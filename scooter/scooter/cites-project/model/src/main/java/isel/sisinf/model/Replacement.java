package isel.sisinf.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Replacement {


    private int number;

    private LocalDateTime dreplacement;

    private String action;


    private ReplacementOrder reporder;


    private Station repstation;


    private Employee employee;

    public Replacement() {}

    public Replacement(int number, LocalDateTime dreplacement, String action, ReplacementOrder reporder, Station repstation, Employee employee) {
        this.number = number;
        this.dreplacement = dreplacement;
        this.action = action;
        this.reporder = reporder;
        this.repstation = repstation;
        this.employee = employee;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDateTime getDreplacement() {
        return dreplacement;
    }

    public void setDreplacement(LocalDateTime dreplacement) {
        this.dreplacement = dreplacement;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public ReplacementOrder getReporder() {
        return reporder;
    }

    public void setReporder(ReplacementOrder reporder) {
        this.reporder = reporder;
    }

    public Station getRepstation() {
        return repstation;
    }

    public void setRepstation(Station repstation) {
        this.repstation = repstation;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Replacement [number=" + number + ", dreplacement=" + dreplacement + ", action=" + action
                + ", reporder=" + reporder + ", repstation=" + repstation + ", employee=" + employee + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Replacement other = (Replacement) obj;
        return number == other.number;
    }
}
