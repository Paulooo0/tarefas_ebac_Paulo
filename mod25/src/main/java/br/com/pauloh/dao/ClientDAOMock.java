package br.com.pauloh.dao;

import java.util.Collection;

import br.com.pauloh.domain.Client;
import br.com.pauloh.exception.TipoChaveNaoEncontradaException;

public class ClientDAOMock implements IClientDAO {

    @Override
    public Boolean save(Client entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public void delete(Long valor) {
        // TODO Auto-generated method stub
    }

    @Override
    public void update(Client entity) throws TipoChaveNaoEncontradaException {
        // TODO Auto-generated method stub
    }

    @Override
    public Client findByCpf(Long valor) {
        Client client = new Client();
        client.setCpf(valor);
        return client;
    }

    @Override
    public Collection<Client> searchAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
