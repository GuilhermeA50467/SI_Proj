package isel.sisinf.model.interfaces;

import java.math.BigDecimal;

public interface IStation {

    public int getId();
    public void setId(int id);

    public BigDecimal getLatitude();
    public void setLatitude(BigDecimal latitude);

    public BigDecimal getLongitude() ;
    public void setLongitude(BigDecimal longitude);
}
