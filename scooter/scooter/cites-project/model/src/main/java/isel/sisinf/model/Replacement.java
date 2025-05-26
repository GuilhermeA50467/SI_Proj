package isel.sisinf.model;

import isel.sisinf.model.interfaces.IReplacement;

import java.time.LocalDateTime;
import java.util.Objects;

public class Replacement implements IReplacement {

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
    @Override
    public int getNumber() {
        return number;
    }
    @Override
    public void setNumber(int number) {
        this.number = number;
    }
    @Override
    public LocalDateTime getDreplacement() {
        return dreplacement;
    }
    @Override
    public void setDreplacement(LocalDateTime dreplacement) {
        this.dreplacement = dreplacement;
    }
    @Override
    public String getAction() {
        return action;
    }
    @Override
    public void setAction(String action) {
        this.action = action;
    }
    @Override
    public ReplacementOrder getReporder() {
        return reporder;
    }
    @Override
    public void setReporder(ReplacementOrder reporder) {
        this.reporder = reporder;
    }
    @Override
    public Station getRepstation() {
        return repstation;
    }
    @Override
    public void setRepstation(Station repstation) {
        this.repstation = repstation;
    }
    @Override
    public Employee getEmployee() {
        return employee;
    }
    @Override
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
