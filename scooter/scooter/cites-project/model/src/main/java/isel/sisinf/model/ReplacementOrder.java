package isel.sisinf.model;

import isel.sisinf.model.interfaces.IReplacementOrder;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "REPLACEMENTORDER")
public class ReplacementOrder implements IReplacementOrder {

    @EmbeddedId
    private ReplacementOrderId id;

    @Column(name = "dorder")
    private LocalDateTime dorder;

    @Column(name = "dreplacement")
    private LocalDateTime dreplacement;

    @Column(name = "roccupation")
    private int roccupation;

    @MapsId("stationId")
    @ManyToOne
    @JoinColumn(name = "station", nullable = false)
    private Station station;

    public ReplacementOrder() {}

    public ReplacementOrder(LocalDateTime dorder, LocalDateTime dreplacement, int roccupation, Station station) {
        this.id = new ReplacementOrderId(dorder, station.getId());
        this.dreplacement = dreplacement;
        this.roccupation = roccupation;
        this.station = station;
    }

    @Override
    public LocalDateTime getDorder() {
        return dorder;
    }
    @Override
    public void setDorder(LocalDateTime dorder) {
        this.dorder = dorder;
    }
    @Override
    public LocalDateTime getDreplacement() {
        return dreplacement;
    }
    @Override
    public void setDreplacement(LocalDateTime dreplacement) {
        this.dreplacement = dreplacement;
    }
    @Override
    public int getRoccupation() {
        return roccupation;
    }
    @Override
    public void setRoccupation(int roccupation) {
        this.roccupation = roccupation;
    }
    @Override
    public Station getStation() {
        return station;
    }
    @Override
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
