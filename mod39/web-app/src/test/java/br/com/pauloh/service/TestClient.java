package br.com.pauloh.service;

import br.com.pauloh.model.Client;

public class TestClient extends Client {
    private Client client;
    private IClientService clientService;

    public TestClient() {
        this.client = new Client();
        this.clientService = new ClientService();

        client.setName("test");
        client.setEmail("test@test");
        client.setPhone(111111111111L);

        client = clientService.create(client);
    }
}
