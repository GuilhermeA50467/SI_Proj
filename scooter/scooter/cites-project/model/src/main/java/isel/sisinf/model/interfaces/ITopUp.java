package isel.sisinf.model.interfaces;

import isel.sisinf.model.Card;

import java.time.LocalDateTime;

public interface ITopUp {

    public LocalDateTime getDttopup();
    public void setDttopup(LocalDateTime dttopup);

    public Card getCard();
    public void setCard(Card card);

    public double getValue();
    public void setValue(double value);
}
