package br.com.pauloh.service.generic;

import java.util.List;
import java.util.UUID;

public interface IGenericService<T> {

    T create(T t);

    T read(UUID id);

    T update(T t);

    void delete(UUID id);

    List<T> searchAll();
}
