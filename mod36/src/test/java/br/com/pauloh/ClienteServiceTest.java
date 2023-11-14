package br.com.pauloh;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.pauloh.dao.ClienteDaoPostgresMock;
import br.com.pauloh.dao.IClienteDAO;
import br.com.pauloh.domain.ClientePostgres;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;
import br.com.pauloh.services.ClienteService;
import br.com.pauloh.services.IClienteService;

public class ClienteServiceTest {
	
	private IClienteService clienteService;
	
	private ClientePostgres cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoPostgresMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {
		cliente = new ClientePostgres();
		cliente.setCpf(12312312312L);
		cliente.setNome("Paulo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		
	}
	
	@Test
	public void pesquisarCliente() throws DAOException {
		ClientePostgres clienteConsultado = clienteService.buscarPorCPF(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		ClientePostgres retorno = clienteService.cadastrar(cliente);
		
		Assert.assertNotNull(retorno);
	}
	
	@Test
	public void excluirCliente() throws DAOException {
		clienteService.excluir(cliente);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, DAOException {
		cliente.setNome("Rodrigo Pires");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Rodrigo Pires", cliente.getNome());
	}
}
