package isel.sisinf.jpa.repositorys;
import isel.sisinf.jpa.AbstractRepository;
import isel.sisinf.model.Station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryStation extends AbstractRepository<Station, Integer> {
    public RepositoryStation(EntityManager em) {
        super(em, Station.class);
    }


    public Map<Station, BigDecimal> getOccupancy() {
        String jpql = "SELECT s, FUNCTION('fx_dock_occupancy', s.id) FROM Station s";

        List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();
        Map<Station, BigDecimal> map = new HashMap<>();
        for (Object[] row : results) {
            Station station = (Station) row[0];
            BigDecimal occupancy = (BigDecimal) row[1];
            map.put(station, occupancy);
        }

        return map;
    }

}
