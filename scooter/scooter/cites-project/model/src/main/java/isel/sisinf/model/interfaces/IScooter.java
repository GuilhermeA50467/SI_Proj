package isel.sisinf.model.interfaces;

import isel.sisinf.model.ScooterModel;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public interface IScooter {
    public int getId();
    public void setId(int id);

    public BigDecimal getWeight();
    public void setWeight(BigDecimal weight);

    public BigDecimal getMaxVelocity();
    public void setMaxVelocity(BigDecimal maxVelocity);

    public int getBattery();
    public void setBattery(int battery);

    public ScooterModel getModel();
    public void setModel(ScooterModel model);

    public Timestamp getVersion();

    public void setVersion(Timestamp version);
}
