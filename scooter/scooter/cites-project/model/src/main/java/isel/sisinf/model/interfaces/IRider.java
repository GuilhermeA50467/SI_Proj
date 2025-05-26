package isel.sisinf.model.interfaces;

import java.time.LocalDateTime;

public interface IRider {
    public int getId();
    public void setId(int id);

    public String getEmail();
    public void setEmail(String email);

    public int getTaxnumber();
    public void setTaxnumber(int taxnumber);

    public String getName();
    public void setName(String name);

    public LocalDateTime getDtregister();
    public void setDtregister(LocalDateTime dtregister);

    public int getCardid();
    public void setCardid(int cardid);

    public double getCredit();
    public void setCredit(double credit);

    public String getTypeofcard();
    public void setTypeofcard(String typeofcard);
}
