
package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.GenericDAOPostgres1;
import br.com.pauloh.domain.ClientePostgres;

public class ClienteDAOPostgres1 extends GenericDAOPostgres1<ClientePostgres, Long> implements IClienteDAO<ClientePostgres> {

	public ClienteDAOPostgres1() {
		super(ClientePostgres.class);
	}
}
