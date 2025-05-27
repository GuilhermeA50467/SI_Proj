package isel.sisinf.model;

import isel.sisinf.model.interfaces.IEmployee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements IEmployee {

    @Id
    @OneToOne
    @JoinColumn(name = "person")
    private Person person;

    @Column(name = "number", unique = true)
    private int number;

    // Constructors
    public Employee() {}

    public Employee(int number, Person person) {
        this.number = number;
        this.person = person;
    }

    // Getters and Setters
    @Override
    public int getNumber() { return number; }
    @Override
    public void setNumber(int number) { this.number = number; }
    @Override
    public Person getPerson() { return person; }
    @Override
    public void setPerson(Person person) { this.person = person; }

    // Utils
    @Override
    public String toString() {
        return "Employee [number=" + number + ", person=" + person + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(person);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return Objects.equals(person, other.person);
    }
}
