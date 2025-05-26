package isel.sisinf.model;
import isel.sisinf.model.interfaces.IClient;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "CLIENT")
public class Client implements IClient {

    @Id
    @OneToOne()
    @JoinColumn(name = "person")
    private Person person;

    @Column(nullable = false, name = "dtregister")
    private LocalDateTime dtRegister;

    // Constructors
    public Client() {}

    public Client(Person person, LocalDateTime dtRegister) {
        this.person = person;
        this.dtRegister = dtRegister;
    }

    // Getters and Setters
    @Override
    public Person getPerson() { return person; }
    @Override
    public void setPerson(Person person) { this.person = person;}
    @Override
    public LocalDateTime getDtRegister(){ return dtRegister; }
    @Override
    public void setDtRegister(LocalDateTime dtRegister) { this.dtRegister = dtRegister; }


    // Utils
    @Override
    public String toString() {
        return String.format("Client { person=%s, dtRegister=%s }", person, dtRegister);
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
