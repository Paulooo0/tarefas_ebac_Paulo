package br.com.pauloh.service;

import org.junit.Assert;
import org.junit.Test;

import br.com.pauloh.dao.ClientDAO;
import br.com.pauloh.dao.IClientDAO;
import br.com.pauloh.mock.ClientDAOMock;

public class ClientServiceTest {
    @Test
    public void testSave() {
        IClientDAO mockDAO = new ClientDAOMock();
        ClientService clientService = new ClientService(mockDAO);
        String success = clientService.save();
        Assert.assertEquals("Sucesso", success);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSaveError() {
        IClientDAO mockDAO = new ClientDAO();
        ClientService clientService = new ClientService(mockDAO);
        String success = clientService.save();
        Assert.assertEquals("Sucesso", success);
    }
}
