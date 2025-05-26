package isel.sisinf.model;

import java.util.Objects;

public class Card {

    private int id;
    private double credit;
    private TypeOfCard typeofcard;
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
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public double getCredit() { return credit; }
    public void setCredit(double credit) { this.credit = credit; }

    public TypeOfCard getTypeofcard() { return typeofcard; }
    public void setTypeofcard(TypeOfCard typeofcard) { this.typeofcard = typeofcard; }

    public Client getClient() { return client; }
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
