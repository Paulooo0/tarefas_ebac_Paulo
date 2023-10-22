package br.com.pauloh;

import org.junit.Assert;
import org.junit.Test;

public class ClientTest {

    @Test
    public void testClient() {
        Client client = new Client();

		client.adicionarNome("Paulo");

		Assert.assertEquals("Paulo", client.getNome());
    }
}
