package br.com.pauloh.service;

import java.util.UUID;

import br.com.pauloh.model.Client;
import br.com.pauloh.service.generic.GenericService;

public class ClientService extends GenericService<Client, UUID> implements IClientService {

    public ClientService() {
        super(Client.class);
        new GenericService<>(Client.class);
    }
    
}
