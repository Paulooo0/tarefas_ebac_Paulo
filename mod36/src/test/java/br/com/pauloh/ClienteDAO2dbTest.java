/**
 * 
 */
package br.com.pauloh;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.Random;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.com.pauloh.dao.ClienteDAOPostgres1;
import br.com.pauloh.dao.ClienteDAOPostgres2;
import br.com.pauloh.dao.IClienteDAO;
import br.com.pauloh.domain.ClientePostgres;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.exceptions.MaisDeUmRegistroException;
import br.com.pauloh.exceptions.TableException;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author Paulo.H
 *
 */
public class ClienteDAO2dbTest {
	
	private IClienteDAO<ClientePostgres> clientePG1Dao;
	
	private IClienteDAO<ClientePostgres> clientePG2Dao;
	
	private Random rd;
	
	public ClienteDAO2dbTest() {
		this.clientePG1Dao = new ClienteDAOPostgres1();
		this.clientePG2Dao = new ClienteDAOPostgres2();
		rd = new Random();
	}
	
	@After
	public void end() throws DAOException {
		Collection<ClientePostgres> list1 = clientePG1Dao.buscarTodos();
		excluir1(list1);
		
		Collection<ClientePostgres> list2 = clientePG2Dao.buscarTodos();
		excluir2(list2);
	}
	
	private void excluir1(Collection<ClientePostgres> list) {
		list.forEach(cli -> {
			try {
				clientePG1Dao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	private void excluir2(Collection<ClientePostgres> list) {
		list.forEach(cli -> {
			try {
				clientePG2Dao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws TipoChaveNaoEncontradaException, DAOException, MaisDeUmRegistroException, TableException {
		ClientePostgres cliente = criarCliente();
		clientePG1Dao.cadastrar(cliente);
		
		ClientePostgres clienteConsultado = clientePG1Dao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		cliente.setId(null);
		clientePG2Dao.cadastrar(cliente);
		
		ClientePostgres clienteConsultado2 = clientePG2Dao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado2);
		
	}

	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClientePostgres cliente = criarCliente();
		ClientePostgres retorno = clientePG1Dao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClientePostgres clienteConsultado = clientePG1Dao.consultar(retorno.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clientePG1Dao.excluir(cliente);
		
		ClientePostgres clienteConsultado1 = clientePG1Dao.consultar(retorno.getId());
		Assert.assertNull(clienteConsultado1);
	}
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClientePostgres cliente = criarCliente();
		ClientePostgres retorno = clientePG1Dao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClientePostgres clienteConsultado = clientePG1Dao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clientePG1Dao.excluir(cliente);
		clienteConsultado = clientePG1Dao.consultar(cliente.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClientePostgres cliente = criarCliente();
		ClientePostgres retorno = clientePG1Dao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClientePostgres clienteConsultado = clientePG1Dao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Paulo H");
		clientePG1Dao.alterar(clienteConsultado);
		
		ClientePostgres clienteAlterado = clientePG1Dao.consultar(clienteConsultado.getId());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Paulo H", clienteAlterado.getNome());
		
		clientePG1Dao.excluir(cliente);
		clienteConsultado = clientePG1Dao.consultar(clienteAlterado.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		ClientePostgres cliente = criarCliente();
		ClientePostgres retorno = clientePG1Dao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClientePostgres cliente1 = criarCliente();
		ClientePostgres retorno1 = clientePG1Dao.cadastrar(cliente1);
		Assert.assertNotNull(retorno1);
		
		Collection<ClientePostgres> list = clientePG1Dao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clientePG1Dao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<ClientePostgres> list1 = clientePG1Dao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
	
	private ClientePostgres criarCliente() {
		ClientePostgres cliente = new ClientePostgres();
		cliente.setCpf(rd.nextLong());
		cliente.setNome("Paulo");
		cliente.setCidade("São Paulo");
		cliente.setEnd("End");
		cliente.setEstado("SP");
		cliente.setNumero(10);
		cliente.setTel(1199999999L);
		return cliente;
	}
}
