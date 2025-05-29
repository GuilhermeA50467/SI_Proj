package isel.sisinf.jpa.repositorys;
import isel.sisinf.jpa.AbstractRepository;
import isel.sisinf.model.Rider;
import jakarta.persistence.EntityManager;

public class RepositoryRider extends AbstractRepository<Rider, Integer> {
    public RepositoryRider(EntityManager em) {
        super(em, Rider.class);
    }

}



