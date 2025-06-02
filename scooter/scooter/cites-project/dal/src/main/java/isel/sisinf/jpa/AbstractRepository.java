package isel.sisinf.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.util.List;

public abstract class AbstractRepository<T, K> implements IRepository<T, K> {

    protected final EntityManager em;

    private final Class<T> entityClass;

    public AbstractRepository(EntityManager em, Class<T> entityClass) {
        this.em = em;
        this.entityClass = entityClass;
    }

    @Override
    public T create(T entity) {
        em.persist(entity);
        em.flush();
        return entity;
    }

    @Override
    public T update(T entity) {
        return em.merge(entity);
    }

    @Override
    public T delete(T entity) {
        em.remove(em.contains(entity) ? entity : em.merge(entity));
        em.flush();
        return entity;
    }

    @Override
    public List<T> find(String jpql, Object... params) {
        Query query = em.createQuery(jpql);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }


    @Override
    public T findByKey(K key){
        String queryName = String.format(entityClass.getSimpleName() + ".findByKey");
        return em.createNamedQuery(queryName,entityClass)
                .setParameter("key", key)
                .getSingleResult();
    }
}
