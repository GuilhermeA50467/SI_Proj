package isel.sisinf.model;


import java.time.LocalDateTime;
import java.util.Objects;


public class TopUp {

    private LocalDateTime dttopup;
    private Card card;
    private double value;

    public TopUp() {}

    public TopUp(LocalDateTime dttopup, Card card, double value) {
        this.dttopup = dttopup;
        this.card = card;
        this.value = value;
    }

    public LocalDateTime getDttopup() {
        return dttopup;
    }

    public void setDttopup(LocalDateTime dttopup) {
        this.dttopup = dttopup;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public double getValue() {
        return value;
    }

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
