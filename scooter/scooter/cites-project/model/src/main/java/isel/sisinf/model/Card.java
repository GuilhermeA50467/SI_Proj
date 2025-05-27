package isel.sisinf.model;

import isel.sisinf.model.interfaces.ICard;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "CARD")
public class Card implements ICard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "credit")
    private double credit;

    @ManyToOne
    @JoinColumn(name = "typeofcard")
    private TypeOfCard typeofcard;

    @ManyToOne
    @JoinColumn(name = "client")
    private Client client;

    // Constructors
    public Card() {}

    public Card(int id, double credit, TypeOfCard typeofcard, Client client) {
        this.id = id;
        this.credit = credit;
        this.typeofcard = typeofcard;
        this.client = client;
    }

    // Getters and Setters
    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public double getCredit() { return credit; }
    @Override
    public void setCredit(double credit) { this.credit = credit; }
    @Override
    public TypeOfCard getTypeofcard() { return typeofcard; }
    @Override
    public void setTypeofcard(TypeOfCard typeofcard) { this.typeofcard = typeofcard; }
    @Override
    public Client getClient() { return client; }
    @Override
    public void setClient(Client client) { this.client = client; }

    // Utils
    @Override
    public String toString() {
        return "Card [id=" + id + ", credit=" + credit + ", typeofcard=" + typeofcard + ", client=" + client + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card other = (Card) obj;
        return id == other.id;
    }
}
