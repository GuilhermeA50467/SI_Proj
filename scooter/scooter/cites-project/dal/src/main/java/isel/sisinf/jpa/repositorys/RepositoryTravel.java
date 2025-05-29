package isel.sisinf.jpa.repositorys;

import isel.sisinf.jpa.AbstractRepository;
import isel.sisinf.model.Travel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.StoredProcedureQuery;

public class RepositoryTravel extends AbstractRepository<Travel, Integer> {

    public RepositoryTravel(EntityManager em) {
        super(em, Travel.class);
    }

    public void startTrip(int dockId, int clientId) {
        StoredProcedureQuery query = em.createStoredProcedureQuery("startTrip");
        query.registerStoredProcedureParameter(1, Integer.class, jakarta.persistence.ParameterMode.IN);
        query.registerStoredProcedureParameter(2, Integer.class, jakarta.persistence.ParameterMode.IN);

        query.setParameter(1, dockId);
        query.setParameter(2, clientId);

        query.execute();
    }
}