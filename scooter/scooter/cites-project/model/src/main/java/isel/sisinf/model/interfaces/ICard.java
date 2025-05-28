package isel.sisinf.model.interfaces;

import isel.sisinf.model.Client;
import isel.sisinf.model.TypeOfCard;

import java.math.BigDecimal;

public interface ICard {
    public int getId();
    public void setId(int id);

    public BigDecimal getCredit();
    public void setCredit(BigDecimal credit);

    public TypeOfCard getTypeofcard();
    public void setTypeofcard(TypeOfCard typeofcard);

    public Client getClient();
    public void setClient(Client client);
}
