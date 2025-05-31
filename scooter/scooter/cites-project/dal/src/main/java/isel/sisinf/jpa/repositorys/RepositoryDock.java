package isel.sisinf.jpa.repositorys;

import isel.sisinf.jpa.AbstractRepository;
import isel.sisinf.model.Dock;
import isel.sisinf.model.Scooter;
import jakarta.persistence.EntityManager;

public class RepositoryDock extends AbstractRepository<Dock,Integer> {

    public RepositoryDock(EntityManager em) {
        super(em, Dock.class);
    }

    public void placeScooterInDock(int dockId, int scooterId) {

        Dock dock = em.find(Dock.class, dockId);
        Scooter scooter = em.find(Scooter.class, scooterId);

        if (dock == null) {
            throw new IllegalArgumentException("Dock not found");
        }

        if (!"free".equalsIgnoreCase(dock.getState())) {
            throw new IllegalStateException("Dock is not free");
        }

        if (scooter == null) {
            throw new IllegalArgumentException("Scooter not found");
        }

        dock.setScooter(scooter);
        dock.setState("occupy");
    }
}
