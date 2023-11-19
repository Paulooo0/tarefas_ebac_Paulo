package br.com.pauloh.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.pauloh.model.Client;

public class ClientServiceTest {
    private static IClientService clientService;
    private static Client client;

    @Before
    public void setup() {
        clientService = new ClientService();

        client = new Client();
        client.setName("test");
        client.setEmail("test@test");
        client.setPhone("111111111111");

        clientService.create(client);
    }

    @After
    public void tearDown() {
        clientService.delete(client.getId());
    }

    @Test
    public void createTest() {
        assertNotNull(client.getId());
    }

    @Test
    public void readTest() {
        assertNotNull(clientService.read(client.getId()));
    }

    @Test
    public void updateTest() {
        client.setName("test2");
        clientService.update(client);

        assertEquals(client.getName(), "test2");
    }

    @Test
    public void deleteTest() {
        clientService.delete(client.getId());

        Client read = clientService.read(client.getId());

        assertNull(read);
    }
}
