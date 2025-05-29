package isel.sisinf.jpa;
import isel.sisinf.model.Rider;
import jakarta.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AbstractRepositoryRider extends AbstractRepository<Rider, Integer> {
    public AbstractRepositoryRider(EntityManager em) {
        super(em, Rider.class);
    }
}



