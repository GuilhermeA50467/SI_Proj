package isel.sisinf.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class TopUpId implements Serializable {

    @Column(name = "dttopup")
    private LocalDateTime dtTopup;

    @Column(name = "card")
    private int cardId;

    public TopUpId() {}

    public TopUpId(LocalDateTime dtTopup, int cardId) {
        this.dtTopup = dtTopup;
        this.cardId = cardId;
    }

    public LocalDateTime getDtTopup() {
        return dtTopup;
    }

    public void setDtTopup(LocalDateTime dtTopup) {
        this.dtTopup = dtTopup;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TopUpId)) return false;
        TopUpId topUpId = (TopUpId) o;
        return cardId == topUpId.cardId &&
                Objects.equals(dtTopup, topUpId.dtTopup);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dtTopup, cardId);
    }
}