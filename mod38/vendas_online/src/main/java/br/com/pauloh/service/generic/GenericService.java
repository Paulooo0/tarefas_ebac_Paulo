package br.com.pauloh.service.generic;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericService<T> implements IGenericService<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> entityClass;

    public GenericService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    @Override
    public T create(T t) {
        entityManager.persist(t);
        return t;
    }

    @Override
    public T read(UUID id) {
        T entity = entityManager.find(entityClass,id);
        return entity;
    }

    @Override
    public T update(T t) {
        entityManager.merge(t);
        return t;
    }

    @Override
    public void delete(UUID id) {
        T t = read(id);
        if (t != null) {
            try {
                entityManager.remove(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            throw new RuntimeException("Entity not found");
        }
    }

    @Override
    public List<T> searchAll() {
        List<T> entities = entityManager.createQuery("SELECT t FROM " + entityClass.getSimpleName() + " t").getResultList();
        return entities;
    }
}
