package isel.sisinf.model;


import isel.sisinf.model.interfaces.IStation;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@NamedStoredProcedureQuery(
        name = "FUNC",
        procedureName = "fx_dock_occupancy",
        parameters = {
                @StoredProcedureParameter(mode = ParameterMode.IN,type = Integer.class),
                @StoredProcedureParameter(mode = ParameterMode.OUT,type = Number.class),
        }
)
@Table(name = "STATION")
public class Station implements IStation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "latitude", nullable = false, precision = 6, scale = 4)
    private BigDecimal latitude;

    @Column(name = "longitude", nullable = false, precision = 6, scale = 4)
    private BigDecimal longitude;

    // Constructors
    public Station() {}

    public Station(BigDecimal latitude, BigDecimal longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    // Getters and Setters
    @Override
    public int getId() { return id; }
    @Override
    public void setId(int id) { this.id = id; }
    @Override
    public BigDecimal getLatitude() { return latitude; }
    @Override
    public void setLatitude(BigDecimal latitude) { this.latitude = latitude; }
    @Override
    public BigDecimal getLongitude() { return longitude; }
    @Override
    public void setLongitude(BigDecimal longitude) { this.longitude = longitude; }

    // Utils
    @Override
    public String toString() {
        return "Station [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Station other = (Station) obj;
        return id == other.id;
    }
}
