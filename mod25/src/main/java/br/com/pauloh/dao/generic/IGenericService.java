package br.com.pauloh.dao.generic;

import br.com.pauloh.dao.Persistent;
import br.com.pauloh.domain.Client;
import br.com.pauloh.exception.TipoChaveNaoEncontradaException;

public interface IGenericService <T extends Persistent> {
    Boolean save(T entity) throws TipoChaveNaoEncontradaException;

    Client findByCpf(Long value);

    void delete(Long value);

    void update(T entity) throws TipoChaveNaoEncontradaException;
}
