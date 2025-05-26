package isel.sisinf.model.interfaces;

import isel.sisinf.model.ScooterModel;

import java.time.LocalDateTime;

public interface IScooter {
    public int getId();
    public void setId(int id);

    public double getWeight();
    public void setWeight(double weight);

    public double getMaxVelocity();
    public void setMaxVelocity(double maxVelocity);

    public int getBattery();
    public void setBattery(int battery);

    public ScooterModel getModel();
    public void setModel(ScooterModel model);

    public LocalDateTime getVersion();

    public void setVersion(LocalDateTime version);
}
