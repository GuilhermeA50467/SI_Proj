package isel.sisinf.model;


import isel.sisinf.model.interfaces.ITypeOfCard;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "TYPEOFCARD")
public class TypeOfCard implements ITypeOfCard {

    @Id
    @Column(name = "reference")
    private String reference;

    @Column(name = "nodays")
    private int nodays;

    @Column(name = "price")
    private double price;

    // Constructors
    public TypeOfCard() {}

    public TypeOfCard(String reference, int nodays, double price) {
        this.reference = reference;
        this.nodays = nodays;
        this.price = price;
    }

    // Getters and Setters
    @Override
    public String getReference() { return reference; }
    @Override
    public void setReference(String reference) { this.reference = reference; }
    @Override
    public int getNodays() { return nodays; }
    @Override
    public void setNodays(int nodays) { this.nodays = nodays; }
    @Override
    public double getPrice() { return price; }
    @Override
    public void setPrice(double price) { this.price = price; }

    // Utility methods
    @Override
    public String toString() {
        return "TypeOfCard [reference=" + reference + ", nodays=" + nodays + ", price=" + price + "]";
    }

    @Override
    public int hashCode() { return Objects.hash(reference); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        TypeOfCard other = (TypeOfCard) obj;
        return Objects.equals(reference, other.reference);
    }
}
