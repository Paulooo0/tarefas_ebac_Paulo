package br.com.pauloh.dao;

import java.util.Collection;

import br.com.pauloh.domain.ClientePostgres;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

public class ClienteDaoPostgresMock implements IClienteDAO<ClientePostgres> {

	@Override
	public ClientePostgres cadastrar(ClientePostgres entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(ClientePostgres entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ClientePostgres alterar(ClientePostgres entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ClientePostgres consultar(Long valor) {
		ClientePostgres cliente = new ClientePostgres();
		cliente.setCpf(valor);
		return cliente;
	}

	@Override
	public Collection<ClientePostgres> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}
}
