package br.com.pauloh.dao.generic;

import br.com.pauloh.dao.Persistent;
import br.com.pauloh.domain.Client;
import br.com.pauloh.exception.TipoChaveNaoEncontradaException;

public abstract class GenericService<T extends Persistent> implements IGenericService<T> {
    private IGenericDAO<T> dao;

    public GenericService(IGenericDAO<T> dao) {
        this.dao = dao;
    }

    @Override
    public Boolean save(T entity) throws TipoChaveNaoEncontradaException {
        return dao.save(entity);
    }

    @Override
    public Client findByCpf(Long value) {
        return (Client) dao.findByCpf(value);
    }

    @Override
    public void delete(Long value) {
        dao.delete(value);
    }

    @Override
    public void update(T entity) throws TipoChaveNaoEncontradaException {
        dao.update(entity);
    }
    
}
