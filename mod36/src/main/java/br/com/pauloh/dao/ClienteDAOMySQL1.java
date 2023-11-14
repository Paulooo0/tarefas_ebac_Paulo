package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.GenericDAOMySQL1;
import br.com.pauloh.domain.ClienteMySQL;

public class ClienteDAOMySQL1 extends GenericDAOMySQL1<ClienteMySQL, Long> implements IClienteDAO<ClienteMySQL> {

	public ClienteDAOMySQL1() {
		super(ClienteMySQL.class);
	}
}
