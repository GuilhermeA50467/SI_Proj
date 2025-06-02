package isel.sisinf.jpa.repositorys;
import isel.sisinf.jpa.AbstractRepository;
import isel.sisinf.model.Station;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositoryStation extends AbstractRepository<Station, Integer> {
    public RepositoryStation(EntityManager em) {
        super(em, Station.class);
    }


//    public Map<Station, BigDecimal> getOccupancy() {
//        String jpql = "SELECT s, FUNCTION('fx_dock_occupancy', s.id) FROM Station s";
//
//        List<Object[]> results = em.createQuery(jpql, Object[].class).getResultList();
//        Map<Station, BigDecimal> map = new HashMap<>();
//        for (Object[] row : results) {
//            Station station = (Station) row[0];
//            BigDecimal occupancy = (BigDecimal) row[1];
//            map.put(station, occupancy);
//        }
//
//        return map;
//    }


    public Map<Station, BigDecimal> getOccupancy() {
        List<Station> stations = em.createQuery("SELECT s FROM Station s", Station.class).getResultList();
        Map<Station, BigDecimal> map = new HashMap<>();

        for (Station station : stations) {
            StoredProcedureQuery query = em.createNamedStoredProcedureQuery("FUNC");
            query.setParameter(1, station.getId());


            query.execute();

            BigDecimal occupancy = (BigDecimal) query.getOutputParameterValue(2);
            map.put(station, occupancy);
        }

        return map;
    }

}
