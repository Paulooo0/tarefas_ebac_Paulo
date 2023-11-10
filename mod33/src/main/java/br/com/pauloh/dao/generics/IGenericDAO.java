package br.com.pauloh.dao.generics;

public interface IGenericDAO<T> {
    T create(T entity);
    T read(Long id);
    T update(T entity);
    void delete(T entity);
}
