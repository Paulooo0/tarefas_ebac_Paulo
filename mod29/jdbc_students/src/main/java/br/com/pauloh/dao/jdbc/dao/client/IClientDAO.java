package br.com.pauloh.dao.jdbc.dao.client;

import java.util.List;

import br.com.pauloh.domain.Client;

public interface IClientDAO {
    public Integer create(Client client) throws Exception;

    public Client read(String code) throws Exception;

    public Integer update(Client client) throws Exception;

    public Integer delete(Client client) throws Exception;

    public List<Client> readAll() throws Exception;
}
