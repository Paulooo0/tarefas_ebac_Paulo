package br.com.pauloh.dao.generic;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO<T> implements IGenericDAO<T>{

    private Class<T> entityClass;

    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public GenericDAO() {
        
    }

    @Override
    public T create(T entity) {
        EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return entity;
    }

    @Override
    public T update(T entity) {
        EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return entity;
    }

    @Override
    public void delete(T entity) {
        EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        T mergedEntity = entityManager.merge(entity);

        entityManager.remove(mergedEntity);
        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        entity = null;
    }

    @Override
    public T findById(Long id) {
        EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        T entity = entityManager.find(entityClass, id);

        entityManager.close();
        entityManagerFactory.close();

        return entity;
    }

    @Override
    public List<T> findAll() {
        EntityManagerFactory entityManagerFactory = 
            Persistence.createEntityManagerFactory("ExemploJPA");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<T> entities = entityManager
            .createQuery("FROM " + entityClass.getSimpleName(), entityClass)
            .getResultList();
        
        entityManager.close();
        entityManagerFactory.close();

        return entities;
    }


}
