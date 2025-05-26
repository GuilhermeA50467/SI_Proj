package isel.sisinf.model;


import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "PERSON")
public class Person {

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
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getTaxNumber() { return taxNumber; }
    public void setTaxNumber(Integer taxNumber) { this.taxNumber = taxNumber; }

    public String getName() { return name; }
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
