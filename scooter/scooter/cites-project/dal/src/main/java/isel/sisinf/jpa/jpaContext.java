package isel.sisinf.jpa;

import isel.sisinf.jpa.repositorys.RepositoryDock;
import isel.sisinf.jpa.repositorys.RepositoryRider;
import isel.sisinf.jpa.repositorys.RepositoryStation;
import isel.sisinf.jpa.repositorys.RepositoryTravel;
import jakarta.persistence.EntityManager;

public class jpaContext {
    private final EntityManager em;
    private final RepositoryRider repositoryRider;
    private final RepositoryStation repositoryStation;
    private final RepositoryTravel repositoryTravel;
    private final RepositoryDock repositoryDock;

    public jpaContext(EntityManager em) {
        this.em = em;
        this.repositoryRider = new RepositoryRider(em);
        this.repositoryStation = new RepositoryStation(em);
        this.repositoryTravel = new RepositoryTravel(em);
        this.repositoryDock = new RepositoryDock(em);
    }

    public RepositoryRider getRepositoryRider() {
        return repositoryRider;
    }

    public RepositoryStation getRepositoryStation() {
        return repositoryStation;
    }

    public RepositoryTravel getRepositoryTravel() {return repositoryTravel;}

    public RepositoryDock getRepositoryDock() {return repositoryDock;}


    public void beginTransaction() {
        if (!isTransactionActive()) {
            em.getTransaction().begin();
        }
    }

    public void commitTransaction() {
        if (isTransactionActive()) {
            em.getTransaction().commit();
        }
    }

    public void rollbackTransaction() {
        if (isTransactionActive()) {
            em.getTransaction().rollback();
        }
    }

    public boolean isTransactionActive() {
        return em.getTransaction().isActive();
    }
}