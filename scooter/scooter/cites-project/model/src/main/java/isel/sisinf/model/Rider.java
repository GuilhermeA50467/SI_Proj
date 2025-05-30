package isel.sisinf.model;


import isel.sisinf.model.interfaces.IRider;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "Rider")
@NamedQuery(name = "Rider.findByKey", query = "SELECT r FROM Rider r WHERE r.id = :key")
public class Rider implements IRider {

    @Id
    @Column(name="id")
    private int id;
    @Column(name="email")
    private String email;
    @Column(name ="taxnumber")
    private int taxnumber;
    @Column(name ="name")
    private String name;
    @Column(name ="dtregister")
    private LocalDateTime dtregister;
    @Column(name ="cardid")
    private int cardid;
    @Column(name ="credit")
    private double credit;
    @Column(name ="typeofcard")
    private String typeofcard;

    public Rider() {}

    public Rider(int id, String email, int taxnumber, String name, LocalDateTime dtregister, int cardid, double credit, String typeofcard) {
        this.id = id;
        this.email = email;
        this.taxnumber = taxnumber;
        this.name = name;
        this.dtregister = dtregister;
        this.cardid = cardid;
        this.credit = credit;
        this.typeofcard = typeofcard;
    }

    // Getters and setters
    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public String getEmail() { return email; }
    @Override
    public void setEmail(String email) { this.email = email; }
    @Override
    public int getTaxnumber() { return taxnumber; }
    @Override
    public void setTaxnumber(int taxnumber) { this.taxnumber = taxnumber; }
    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }
    @Override
    public LocalDateTime getDtregister() { return dtregister; }
    @Override
    public void setDtregister(LocalDateTime dtregister) { this.dtregister = dtregister; }
    @Override
    public int getCardid() { return cardid; }
    @Override
    public void setCardid(int cardid) { this.cardid = cardid; }
    @Override
    public double getCredit() { return credit; }
    @Override
    public void setCredit(double credit) { this.credit = credit; }
    @Override
    public String getTypeofcard() { return typeofcard; }
    @Override
    public void setTypeofcard(String typeofcard) { this.typeofcard = typeofcard; }

    @Override
    public String toString() {
        return "Rider [id=" + id + ", email=" + email + ", taxnumber=" + taxnumber + ", name=" + name + ", dtregister=" + dtregister + ", cardid=" + cardid + ", credit=" + credit + ", typeofcard=" + typeofcard + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Rider other = (Rider) obj;
        return id == other.id;
    }
}
