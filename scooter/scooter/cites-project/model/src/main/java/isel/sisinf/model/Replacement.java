package isel.sisinf.model;

import isel.sisinf.model.interfaces.IReplacement;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "REPLACEMENT")
public class Replacement implements IReplacement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "number")
    private int number;

    @Column(name = "dreplacement", nullable = false)
    private LocalDateTime dreplacement;

    @Column(name = "action")
    private String action;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "reporder", referencedColumnName = "dorder"),
            @JoinColumn(name = "repstation", referencedColumnName = "station")
    })
    private ReplacementOrder reporder;

    @Column(name = "repstation", nullable = false)
    private int repstation;

    @ManyToOne
    @JoinColumn(name = "employee", nullable = false)
    private Employee employee;

    public Replacement() {}

    public Replacement(int number, LocalDateTime dreplacement, String action, ReplacementOrder reporder, int repstation, Employee employee) {
        this.number = number;
        this.dreplacement = dreplacement;
        setAction(action);
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
        if (!action.equals("inplace") && !action.equals("remove")) {
            throw new IllegalArgumentException("Action inválido: " + action);
        }
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
    public int getRepstation() {
        return repstation;
    }
    @Override
    public void setRepstation(int repstation) {
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
