package isel.sisinf.model;


import java.util.Objects;


public class TypeOfCard {

    private String reference;
    private int nodays;
    private double price;

    // Constructors
    public TypeOfCard() {}

    public TypeOfCard(String reference, int nodays, double price) {
        this.reference = reference;
        this.nodays = nodays;
        this.price = price;
    }

    // Getters and Setters
    public String getReference() { return reference; }
    public void setReference(String reference) { this.reference = reference; }

    public int getNodays() { return nodays; }
    public void setNodays(int nodays) { this.nodays = nodays; }

    public double getPrice() { return price; }
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
