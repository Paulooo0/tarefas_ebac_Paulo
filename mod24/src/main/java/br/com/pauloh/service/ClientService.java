package br.com.pauloh.service;

import br.com.pauloh.dao.IClientDAO;

public class ClientService {
    private IClientDAO clientDAO;
    
    public ClientService(IClientDAO clientDAO) {
        // clientDAO = new ClientDAO();
        // clientDAO = new ClientDAOMock();
        this.clientDAO = clientDAO;
    }

    public String save() {
        clientDAO.save();
        return "Sucesso";
    }
}
