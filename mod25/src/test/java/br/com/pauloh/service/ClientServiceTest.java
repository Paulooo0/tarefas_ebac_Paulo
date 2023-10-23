package br.com.pauloh.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pauloh.dao.ClientDAOMock;
import br.com.pauloh.dao.IClientDAO;
import br.com.pauloh.domain.Client;
import br.com.pauloh.exception.TipoChaveNaoEncontradaException;
import br.com.pauloh.services.ClientService;
import br.com.pauloh.services.IClientService;

public class ClientServiceTest {

    private IClientService clientService;

    private Client client;

    public ClientServiceTest() {
        IClientDAO dao = new ClientDAOMock();
        clientService = new ClientService(dao);
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

        clientService.save(client);
    }

    @Test
    public void searchClient() {
        Client consultedClient = clientService.findByCpf(client.getCpf());

        Assert.assertNotNull(consultedClient);
    }

    @Test
    public void saveClient() throws TipoChaveNaoEncontradaException {
        Boolean bool = clientService.save(client);

        Assert.assertTrue(bool);
    }

    @Test
    public void deleteClient() {
        clientService.delete(client.getCpf());
    }

    @Test
    public void updateClient() throws TipoChaveNaoEncontradaException {
        client.setName("Paulo 2");
        clientService.update(client);

        Assert.assertEquals("Paulo 2", client.getName());
    }
}
