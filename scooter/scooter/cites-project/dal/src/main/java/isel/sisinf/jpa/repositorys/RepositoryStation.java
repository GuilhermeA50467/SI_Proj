package isel.sisinf.jpa.repositorys;
import isel.sisinf.jpa.AbstractRepository;
import isel.sisinf.model.Station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;

import java.math.BigDecimal;

public class RepositoryStation extends AbstractRepository<Station, Integer> {
    public RepositoryStation(EntityManager em) {
        super(em, Station.class);
    }

    public BigDecimal getDockOccupancy(int stationId) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("sp_chama_fx_dock_occupancy");
        query.registerStoredProcedureParameter(1, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(2, BigDecimal.class, jakarta.persistence.ParameterMode.OUT);

        query.setParameter(1, stationId);
        query.execute();

        return (BigDecimal) query.getOutputParameterValue(2);
    }
}
