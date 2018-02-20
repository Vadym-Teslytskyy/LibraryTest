package ua.repository;

import java.io.Serializable;
import java.util.List;

public interface CrudRepository<T, Id extends Serializable> {

    public void save(T entity);

    public void update(T entity);

    public T findById(Id id);

    public List<T> findAll();

    public void deleteById(Id id);

}
