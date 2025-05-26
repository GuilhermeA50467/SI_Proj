package isel.sisinf.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Client {

    private Person person;
    private LocalDateTime dtregister;

    // Constructors
    public Client() {}

    public Client(Person person, LocalDateTime dtregister) {
        this.person = person;
        this.dtregister = dtregister;
    }

    // Getters and Setters
    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }

    public LocalDateTime getDtregister() { return dtregister; }
    public void setDtregister(LocalDateTime dtregister) { this.dtregister = dtregister; }

    // Utils
    @Override
    public String toString() {
        return "Client [person=" + person + ", dtregister=" + dtregister + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(person);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client other = (Client) obj;
        return Objects.equals(person, other.person);
    }
}
