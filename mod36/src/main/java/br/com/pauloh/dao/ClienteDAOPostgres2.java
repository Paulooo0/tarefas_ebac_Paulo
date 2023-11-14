package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.GenericDAOPostgres2;
import br.com.pauloh.domain.ClientePostgres;

public class ClienteDAOPostgres2 extends GenericDAOPostgres2<ClientePostgres, Long> implements IClienteDAO<ClientePostgres> {

	public ClienteDAOPostgres2() {
		super(ClientePostgres.class);
	}
}
