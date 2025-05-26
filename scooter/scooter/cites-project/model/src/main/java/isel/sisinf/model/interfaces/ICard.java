package isel.sisinf.model.interfaces;

import isel.sisinf.model.Client;
import isel.sisinf.model.TypeOfCard;

public interface ICard {
    public int getId();
    public void setId(int id);

    public double getCredit();
    public void setCredit(double credit);

    public TypeOfCard getTypeofcard();
    public void setTypeofcard(TypeOfCard typeofcard);

    public Client getClient();
    public void setClient(Client client);
}
