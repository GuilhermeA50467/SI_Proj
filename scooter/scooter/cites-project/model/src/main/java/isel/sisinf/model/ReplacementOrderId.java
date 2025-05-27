package isel.sisinf.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

// criado esta classe pois a chave primaria é composta
@Embeddable
public class ReplacementOrderId implements Serializable {

    @Column(name = "dorder")
    private LocalDateTime dorder;

    @Column(name = "station")
    private Integer stationId;

    // Construtores, getters, setters, equals e hashCode

    public ReplacementOrderId() {}

    public ReplacementOrderId(LocalDateTime dorder, Integer stationId) {
        this.dorder = dorder;
        this.stationId = stationId;
    }

    public LocalDateTime getDorder() { return dorder; }
    public void setDorder(LocalDateTime dorder) { this.dorder = dorder; }

    public Integer getStationId() { return stationId; }
    public void setStationId(Integer stationId) { this.stationId = stationId; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReplacementOrderId)) return false;
        ReplacementOrderId that = (ReplacementOrderId) o;
        return Objects.equals(dorder, that.dorder) && Objects.equals(stationId, that.stationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dorder, stationId);
    }
}
