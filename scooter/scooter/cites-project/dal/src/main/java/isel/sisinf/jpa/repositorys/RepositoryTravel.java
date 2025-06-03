package isel.sisinf.jpa.repositorys;

import isel.sisinf.jpa.AbstractRepository;
import isel.sisinf.model.Client;
import isel.sisinf.model.Travel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureQuery;

public class RepositoryTravel extends AbstractRepository<Travel, Integer> {

    public RepositoryTravel(EntityManager em) {
        super(em, Travel.class);
    }

    public void startTrip(int dockId, int clientId) {

        Client cliente = em.find(Client.class, clientId);

        if(cliente == null) {
            throw new IllegalArgumentException("Cliente com ID " + clientId + " não existe");
        }

        em.createNativeQuery("CALL startTrip(?, ?)")
                .setParameter(1, dockId)
                .setParameter(2, clientId)
                .executeUpdate();

    }
}