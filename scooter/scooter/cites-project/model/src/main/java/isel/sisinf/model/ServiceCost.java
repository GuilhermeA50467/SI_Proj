package isel.sisinf.model;


import isel.sisinf.model.interfaces.IServiceCost;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;


public class ServiceCost implements IServiceCost {

    private double unlock;
    private double usable;

    public ServiceCost() {}

    public ServiceCost(double unlock, double usable) {
        this.unlock = unlock;
        this.usable = usable;
    }
    @Override
    public double getUnlock() {
        return unlock;
    }
    @Override
    public void setUnlock(double unlock) {
        this.unlock = unlock;
    }
    @Override
    public double getUsable() {
        return usable;
    }
    @Override
    public void setUsable(double usable) {
        this.usable = usable;
    }

    @Override
    public String toString() {
        return "ServiceCost [unlock=" + unlock + ", usable=" + usable + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(unlock);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ServiceCost other = (ServiceCost) obj;
        return Double.compare(other.unlock, unlock) == 0;
    }
}
