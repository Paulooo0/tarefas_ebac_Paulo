package br.com.pauloh.dao.jdbc.dao.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.pauloh.domain.Client;

public class ClientDAOTest {
    @Test
    public void testCreate() throws Exception {
        IClientDAO dao = new ClientDAO();
        Client client = new Client();

        client.setCode("01");
        client.setName("Paulo Henrique");
        
        Integer qtd = dao.create(client);
        assertTrue(qtd == 1);

        Client clientDB = dao.read(client.getCode());
        assertNotNull(clientDB);
        assertNotNull(clientDB.getId());
        assertEquals(client.getCode(), clientDB.getCode());
        assertEquals(client.getName(), clientDB.getName());

        Integer qtdDel = dao.delete(clientDB);
        assertNotNull(qtdDel == 1);
    }

    public void testUpdate() throws Exception {
        IClientDAO dao = new ClientDAO();
        Client client = new Client();

        client.setCode("01");
        client.setName("Paulo Henrique");

        Integer qtd = dao.create(client);
        assertTrue(qtd == 1);

        Client client2 = client;
        client2.setName("Paulo Henrique - Atualizado");
        qtd = dao.update(client2);
        assertTrue(qtd == 1);

        Integer qtdDel = dao.delete(client);
        qtdDel += dao.delete(client2);
        assertNotNull(qtdDel == 2);
    }

    public void testReadAll() throws Exception {
        IClientDAO dao = new ClientDAO();
        Client client = new Client();
        
        client.setCode("01");
        client.setName("Paulo Henrique");
        
        dao.create(client);

        List<Client> list = dao.readAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);

        Integer qtdDel = dao.delete(client);
        assertNotNull(qtdDel == 1);
    }
}
