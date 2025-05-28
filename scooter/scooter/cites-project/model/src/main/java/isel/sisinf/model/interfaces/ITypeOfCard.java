package isel.sisinf.model.interfaces;

import java.math.BigDecimal;

public interface ITypeOfCard {
    public String getReference();
    public void setReference(String reference);

    public int getNodays();
    public void setNodays(int nodays);

    public BigDecimal getPrice();
    public void setPrice(BigDecimal price);
}
