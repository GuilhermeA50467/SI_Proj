package isel.sisinf.model;


import java.util.Objects;


public class Person {

    private int id;
    private String email;
    private Integer taxnumber;
    private String name;

    // Constructors
    public Person() {}

    public Person(int id, String email, Integer taxnumber, String name) {
        this.id = id;
        this.email = email;
        this.taxnumber = taxnumber;
        this.name = name;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getTaxnumber() { return taxnumber; }
    public void setTaxnumber(Integer taxnumber) { this.taxnumber = taxnumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    // Utility methods
    @Override
    public String toString() {
        return "Person [id=" + id + ", email=" + email + ", taxnumber=" + taxnumber + ", name=" + name + "]";
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
