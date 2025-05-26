package isel.sisinf.model;


import java.time.LocalDateTime;
import java.util.Objects;


public class Rider {

    private int id;
    private String email;
    private int taxnumber;
    private String name;
    private LocalDateTime dtregister;
    private int cardid;
    private double credit;
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

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public int getTaxnumber() { return taxnumber; }
    public void setTaxnumber(int taxnumber) { this.taxnumber = taxnumber; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public LocalDateTime getDtregister() { return dtregister; }
    public void setDtregister(LocalDateTime dtregister) { this.dtregister = dtregister; }

    public int getCardid() { return cardid; }
    public void setCardid(int cardid) { this.cardid = cardid; }

    public double getCredit() { return credit; }
    public void setCredit(double credit) { this.credit = credit; }

    public String getTypeofcard() { return typeofcard; }
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
