package dao;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import domain.Client;

public class ClientMapDAO implements IClientDAO {

    private Map<Long, Client> map;

    public ClientMapDAO() {
        this.map = new HashMap<>();
    }

    @Override
    public Boolean insert(Client client) {
        if (this.map.containsKey(client.getCpf())) {
            return false;
        } else {
            this.map.put(client.getCpf(), client);
            return true;
        }
    }

    @Override
    public void delete(Long cpf) {
        Client registeredclient = this.map.get(cpf);

        if (registeredclient != null) {
            this.map.remove(registeredclient.getCpf(), registeredclient);
        }
    }

    @Override
    public void change(Client client) {
        Client registeredclient = this.map.get(client.getCpf());

        if (registeredclient != null) {
            registeredclient.setName(client.getName());
            registeredclient.setCpf(client.getCpf());
            registeredclient.setTel(client.getTel());
            registeredclient.setAddress(client.getAddress());
            registeredclient.setNumber(client.getNumber());
            registeredclient.setCity(client.getCity());
            registeredclient.setState(client.getState());
        }
    }

    @Override
    public Client findByCpf(Long cpf) {
        return this.map.get(cpf);
    }

    @Override
    public Collection<Client> searchAll() {
        return this.map.values();
    }
    
}
