package ua.repository.impl;

import ua.controller.EntityManagerFactoryCreator;
import ua.repository.CrudRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

public class CrudRepositoryImpl<T, Id extends Serializable> implements CrudRepository<T, Id> {

    EntityManager em;

    private Class<T> clazz;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public CrudRepositoryImpl() {
    }

    public EntityManager getEntityManager() {
        em = EntityManagerFactoryCreator.factory.createEntityManager();
        return em;
    }

    public EntityManager getEntityManagerWithTransaction() {
        em = EntityManagerFactoryCreator.factory.createEntityManager();
        em.getTransaction().begin();
        return em;
    }

    public void closeEntityManager() {
        em.close();
    }

    public void commitTransactionAndCloseEM() {
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void save(T entity) {
        getEntityManagerWithTransaction().persist(entity);
        commitTransactionAndCloseEM();
    }

    @Override
    public void update(T entity) {
        getEntityManagerWithTransaction().merge(entity);
        commitTransactionAndCloseEM();
    }

    @Override
    public T findById(Id id) {
        T t = getEntityManager().find(clazz, id);
        closeEntityManager();
        return t;
    }

    @Override
    public List<T> findAll() {
        List list = getEntityManager().createQuery(String.format("from %s", clazz.getName())).getResultList();
        closeEntityManager();
        return list;
    }

    @Override
    public void deleteById(Id id) {
        T t = getEntityManager().find(clazz, id);
        em.getTransaction().begin();
        em.remove(t);
        commitTransactionAndCloseEM();
    }

}
