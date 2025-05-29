package isel.sisinf.jpa;

import isel.sisinf.jpa.repositorys.RepositoryRider;
import isel.sisinf.jpa.repositorys.RepositoryStation;
import jakarta.persistence.EntityManager;

public class jpaContext {
    private final EntityManager em;
    private final RepositoryRider repositoryRider;
    private final RepositoryStation repositoryStation;

    public jpaContext(EntityManager em) {
        this.em = em;
        this.repositoryRider = new RepositoryRider(em);
        this.repositoryStation = new RepositoryStation(em);
    }

    public RepositoryRider getRepositoryRider() {
        return repositoryRider;
    }

    public RepositoryStation getRepositoryStation() {
        return repositoryStation;
    }


    public void beginTransaction() {
        if (isTransactionActive()) {
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