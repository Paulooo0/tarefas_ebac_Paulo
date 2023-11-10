package br.com.pauloh.dao.generics;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GenericDAO<T> implements IGenericDAO<T> {
    private Class<T> entityClass;
    public GenericDAO(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    public GenericDAO() {
        
    }
    
    private EntityManagerFactory emf;
    private EntityManager em;
    private void initializeEntityManager() {
        emf = Persistence.createEntityManagerFactory("module_33");
        em = emf.createEntityManager();
    }

    private void closeEntityManager() {
        em.close();
        emf.close();
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
    public T read(Long id) {
        initializeEntityManager();

        T entity = em.find(entityClass, id);

        return entity;
    }

    @Override
    public T update(T entity) {
        initializeEntityManager();

        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();

        closeEntityManager();

        return entity;
    }

    @Override
    public void delete(T entity) {
        initializeEntityManager();

        em.getTransaction().begin();

        T mergedEntity = em.merge(entity);

        em.remove(mergedEntity);
        em.getTransaction().commit();

        closeEntityManager();
    }
    
}
