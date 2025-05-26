package isel.sisinf.model;

import java.time.LocalDateTime;
import java.util.Objects;


public class ReplacementOrder {

    private LocalDateTime dorder;
    private LocalDateTime dreplacement;
    private int roccupation;
    private Station station;

    public ReplacementOrder() {}

    public ReplacementOrder(LocalDateTime dorder, LocalDateTime dreplacement, int roccupation, Station station) {
        this.dorder = dorder;
        this.dreplacement = dreplacement;
        this.roccupation = roccupation;
        this.station = station;
    }

    public LocalDateTime getDorder() {
        return dorder;
    }

    public void setDorder(LocalDateTime dorder) {
        this.dorder = dorder;
    }

    public LocalDateTime getDreplacement() {
        return dreplacement;
    }

    public void setDreplacement(LocalDateTime dreplacement) {
        this.dreplacement = dreplacement;
    }

    public int getRoccupation() {
        return roccupation;
    }

    public void setRoccupation(int roccupation) {
        this.roccupation = roccupation;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }

    @Override
    public String toString() {
        return "ReplacementOrder [dorder=" + dorder + ", dreplacement=" + dreplacement + ", roccupation=" + roccupation
                + ", station=" + station + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(dorder);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        ReplacementOrder other = (ReplacementOrder) obj;
        return Objects.equals(dorder, other.dorder);
    }
}
