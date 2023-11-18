package br.com.pauloh.service.generic;

import java.util.List;

public interface IGenericService<T, E> {
    T create(T entity);
    T read(E value);
    T update(T entity);
    void delete(E value);
    List<T> findAll();
}
