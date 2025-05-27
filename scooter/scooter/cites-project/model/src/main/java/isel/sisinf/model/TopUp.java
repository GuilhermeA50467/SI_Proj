package isel.sisinf.model;


import isel.sisinf.model.interfaces.ITopUp;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "TOPUP")
public class TopUp implements ITopUp {

    @EmbeddedId
    private TopUpId id;

    @Column(name = "dttopup")
    private LocalDateTime dttopup;

    @ManyToOne
    @MapsId("cardId") // vai buscar cardId de TopUpId
    @JoinColumn(name = "card")
    private Card card;

    @Column(name = "value", nullable = false)
    private double value;

    public TopUp() {}

    public TopUp(LocalDateTime dttopup, Card card, double value) {
        this.id = new TopUpId(dttopup, card.getId());
        this.card = card;
        this.value = value;
    }

    @Override
    public LocalDateTime getDttopup() {
        return dttopup;
    }
    @Override
    public void setDttopup(LocalDateTime dttopup) {
        this.dttopup = dttopup;
    }
    @Override
    public Card getCard() {
        return card;
    }
    @Override
    public void setCard(Card card) {
        this.card = card;
    }
    @Override
    public double getValue() {
        return value;
    }
    @Override
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TopUp [dttopup=" + dttopup + ", card=" + card + ", value=" + value + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(dttopup);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        TopUp other = (TopUp) obj;
        return dttopup.equals(other.dttopup);
    }
}
