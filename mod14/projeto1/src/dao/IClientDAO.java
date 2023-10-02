package dao;

import java.util.Collection;

import domain.Client;

public interface IClientDAO {
    public Boolean insert(Client client);
    public void delete(Long cpf);
    public void change(Client client);
    public Client findByCpf(Long cpf);
    public Collection<Client> searchAll();

}
