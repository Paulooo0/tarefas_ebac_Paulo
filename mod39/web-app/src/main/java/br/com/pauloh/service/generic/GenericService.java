package br.com.pauloh.service.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericService<T, E> implements IGenericService<T, E> {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private void initializeEntityManager() {
        emf = Persistence.createEntityManagerFactory("web-app");
        em = emf.createEntityManager();
    }
    private void closeEntityManager() {
        em.close();
        emf.close();
    }

    protected Class<T> entityClass;

    public GenericService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T create(T entity) {
        initializeEntityManager();

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();

        closeEntityManager();
        return entity;
    }

    @Override
    public T read(E value) {
        initializeEntityManager();
        T entity = em.find(entityClass, value);
        closeEntityManager();
        return entity;
    }

    @Override
    public T update(T entity) {
        initializeEntityManager();
        em.getTransaction().begin();
        entity = em.merge(entity);
        em.getTransaction().commit();
        closeEntityManager();
        return entity;
    }

    @Override
    public void delete(E value) {
        initializeEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        T entity = em.find(entityClass, value);
        if (entity != null) {
            em.remove(entity);
        }

        transaction.commit();
        closeEntityManager();
    }

    @Override
    public List<T> findAll() {
        initializeEntityManager();
        List<T> list = em.createQuery("FROM " + entityClass.getName()).getResultList();
        closeEntityManager();
        return list;
    }
}
