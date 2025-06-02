package isel.sisinf.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class TravelId implements Serializable {

    @Column(name = "dinitial")
    private LocalDateTime dinitial;

    @Column(name = "scooter", insertable = false, updatable = false) // cópia do campo scooter que serve só para ler ( para compor a PK )
    private int scooterId;

    public TravelId() {}

    public TravelId(LocalDateTime dinitial, int scooterId) {
        this.dinitial = dinitial;
        this.scooterId = scooterId;
    }

    public LocalDateTime getDinitial() {
        return dinitial;
    }

    public void setDinitial(LocalDateTime dinitial) {
        this.dinitial = dinitial;
    }

    public int getScooterId() {
        return scooterId;
    }

    public void setScooterId(int scooterId) {
        this.scooterId = scooterId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TravelId)) return false;
        TravelId that = (TravelId) o;
        return scooterId == that.scooterId && Objects.equals(dinitial, that.dinitial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dinitial, scooterId);
    }
}
