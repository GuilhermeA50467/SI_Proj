package isel.sisinf.model;

import java.util.Objects;


public class Employee {

    private int number;
    private Person person;

    // Constructors
    public Employee() {}

    public Employee(int number, Person person) {
        this.number = number;
        this.person = person;
    }

    // Getters and Setters
    public int getNumber() { return number; }
    public void setNumber(int number) { this.number = number; }

    public Person getPerson() { return person; }
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
