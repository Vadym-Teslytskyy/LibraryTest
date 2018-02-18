package ua.DAO;

import ua.DAO.DaoInterface;
import ua.controller.EntityManagerFactoryCreator;
import ua.entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

public abstract class AbstractJpaDao<T, Id extends Serializable> implements DaoInterface<T, Id> {

    EntityManager em;

    private Class<T> clazz;

    public final void setClazz(Class<T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public AbstractJpaDao() {
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

    public void closeEntityManagerAndCommit() {
        em.getTransaction().commit();
        em.close();
    }


    public void persist(T entity) {
        getEntityManagerWithTransaction().persist(entity);
        closeEntityManagerAndCommit();
    }


    public void update(T entity) {
        getEntityManagerWithTransaction().merge(entity);
        closeEntityManagerAndCommit();
    }

    @Override
    public T findById(Id id) {
        return getEntityManager().find(clazz, id);
    }

    public void delete(T entity) {
        getEntityManagerWithTransaction().remove(entity);
    }

    @Override
    public List<T> findAll() {
        return getEntityManager().createQuery(String.format("from %s", clazz.getName())).getResultList();
    }

    @Override
    public void deleteById(Id id) {
        T t = getEntityManager().find(clazz, id);
        em.getTransaction().begin();
        em.remove(t);
        closeEntityManagerAndCommit();
    }
}
