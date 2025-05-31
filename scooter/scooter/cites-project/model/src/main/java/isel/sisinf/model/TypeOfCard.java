package isel.sisinf.model;


import isel.sisinf.model.interfaces.ITypeOfCard;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
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
    private BigDecimal price;

    // Constructors
    public TypeOfCard() {}

    public TypeOfCard(String reference, int nodays, BigDecimal price) {
        setReference(reference);
        setNodays(nodays);
        setPrice(price);
    }

    // Getters and Setters
    @Override
    public String getReference() { return reference; }

    @Override
    public void setReference(String reference) {
        if(!"resident".equalsIgnoreCase(reference) && !"tourist".equalsIgnoreCase(reference)){
            throw new IllegalArgumentException("Referência inválida, deve ser 'resident' ou 'tourist'.");
        }
        this.reference = reference.toLowerCase();
    }

    @Override
    public int getNodays() { return nodays; }
    @Override
    public void setNodays(int nodays) {
        if(nodays <= 0){
            throw new IllegalArgumentException("Número de dias deve ser positivo.");
        }
        this.nodays = nodays;
    }
    @Override
    public BigDecimal getPrice() { return price; }
    @Override
    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Preço deve ser positivo.");
        }
        this.price = price;
    }

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
