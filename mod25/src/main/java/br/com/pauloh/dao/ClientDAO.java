package br.com.pauloh.dao;

import java.util.Collection;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Client;

public class ClientDAO extends GenericDAO<Client> implements IClientDAO {
    public ClientDAO() {
        super();
    }
    
    @Override
    public Class<Client> getTipoClasse() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void atualiarDados(Client entity, Client entityCadastrado) {
        // TODO Auto-generated method stub
    }

    @Override
    public Collection<Client> searchAll() {
        // TODO Auto-generated method stub
        return null;
    }

}
