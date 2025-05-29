package isel.sisinf.jpa;


import isel.sisinf.model.Station;
import jakarta.persistence.EntityManager;

public class AbstractRepositoryStation extends AbstractRepository<Station, Integer> {
    public AbstractRepositoryStation(EntityManager em) {
        super(em, Station.class);
    }

    public double getDockOccupancy(int stationId) {
        String sql = "SELECT fx_dock_occupancy(?1)";
        Number result = (Number) em.createNativeQuery(sql)
                .setParameter(1, stationId)
                .getSingleResult();
        return result.doubleValue();
    }
}
