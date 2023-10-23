package br.com.pauloh.dao;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pauloh.domain.Client;
import br.com.pauloh.exception.TipoChaveNaoEncontradaException;

public class ClientDAOTest {
    private IClientDAO clientDAO;
    private Client client;

    public ClientDAOTest() {
        clientDAO = new ClientDAOMock();
    }

    @Before
    public void init() throws TipoChaveNaoEncontradaException {
        client = new Client();
        client.setCpf(12345678901l);
        client.setTel(11987654321l);
        client.setName("Paulo");
        client.setAddress("Rua A");
        client.setNumber(100);
        client.setCity("Sao Paulo");
        client.setState("SP");

        clientDAO.save(client);
    }

    @Test
    public void searchClient() {
        Client consultedClient = clientDAO.findByCpf(client.getCpf());

        Assert.assertNotNull(consultedClient);
    }

    @Test
    public void saveClient() throws TipoChaveNaoEncontradaException {
        Boolean bool = clientDAO.save(client);

        Assert.assertTrue(bool);
    }

    @Test
    public void deleteClient() {
        clientDAO.delete(client.getCpf());
    }

    @Test
    public void updateClient() throws TipoChaveNaoEncontradaException {
        client.setName("Paulo 2");
        clientDAO.update(client);

        Assert.assertEquals("Paulo 2", client.getName());
    }
}
