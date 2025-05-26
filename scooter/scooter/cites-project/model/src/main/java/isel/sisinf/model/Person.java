package isel.sisinf.model;


import isel.sisinf.model.interfaces.IPerson;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "PERSON")
public class Person implements IPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "taxnumber")
    private Integer taxNumber;

    @Column(nullable = false, name ="name")
    private String name;

    // Constructors
    public Person() {}

    public Person(int id, String email, Integer taxnumber, String name) {
        this.id = id;
        this.email = email;
        this.taxNumber = taxnumber;
        this.name = name;
    }

    // Getters and Setters
    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public String getEmail() { return email; }
    @Override
    public void setEmail(String email) { this.email = email; }
    @Override
    public Integer getTaxNumber() { return taxNumber; }
    @Override
    public void setTaxNumber(Integer taxNumber) { this.taxNumber = taxNumber; }
    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }

    // Utility methods
    @Override
    public String toString() {
        return String.format("Person [id=" + id + ", email=" + email + ", taxNumber=" + taxNumber + ", name=" + name + "]");
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person other = (Person) obj;
        return id == other.id;
    }
}
