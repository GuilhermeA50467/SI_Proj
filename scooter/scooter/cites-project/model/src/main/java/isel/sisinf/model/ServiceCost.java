package isel.sisinf.model;


import java.util.Objects;


public class ServiceCost {

    private double unlock;
    private double usable;

    public ServiceCost() {}

    public ServiceCost(double unlock, double usable) {
        this.unlock = unlock;
        this.usable = usable;
    }

    public double getUnlock() {
        return unlock;
    }

    public void setUnlock(double unlock) {
        this.unlock = unlock;
    }

    public double getUsable() {
        return usable;
    }

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
