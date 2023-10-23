package br.com.pauloh.services;

import br.com.pauloh.dao.generic.GenericService;
import br.com.pauloh.dao.generic.IGenericDAO;
import br.com.pauloh.domain.Client;

public class ClientService extends GenericService<Client> implements IClientService {

    public ClientService(IGenericDAO<Client> dao) {
        super(dao);
    }
}
