package br.com.pauloh.dao.generic;

import java.util.List;

public interface IGenericDAO<T> {

    T create(T entity);

    T update(T entity);

    void delete(T entity);

    T findById(Long id);

    List<T> findAll();
    
}
