package isel.sisinf.jpa;

import java.util.Collection;

public interface IRepository<T, K> {
    T findByKey(K key);
    Collection<T> find(String jpql, Object... params);
    T create(T entity);
    T update(T entity);
    T delete(T entity);
}
