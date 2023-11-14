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
import br.com.pauloh.dao.IClienteDAO;
import br.com.pauloh.domain.ClientePostgres;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.exceptions.MaisDeUmRegistroException;
import br.com.pauloh.exceptions.TableException;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ClienteDAOTest {
	
	private IClienteDAO<ClientePostgres> clienteDao;

	private Random rd;

	public ClienteDAOTest() {
		clienteDao = new ClienteDAOPostgres1();
		rd = new Random();
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
	
	@After
	public void end() throws DAOException {
		Collection<ClientePostgres> list = clienteDao.buscarTodos();
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
	}
	
	@Test
	public void pesquisarCliente() throws MaisDeUmRegistroException, TableException, TipoChaveNaoEncontradaException, DAOException {
		ClientePostgres cliente = criarCliente();
		clienteDao.cadastrar(cliente);
		
		
		ClientePostgres clienteConsultado = clienteDao.consultar(cliente.getCpf());
		Assert.assertNotNull(clienteConsultado);
	}
	
	@Test
	public void salvarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClientePostgres cliente = criarCliente();
		ClientePostgres retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClientePostgres clienteConsultado = clienteDao.consultar(retorno.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		
		ClientePostgres clienteConsultado1 = clienteDao.consultar(retorno.getId());
		Assert.assertNull(clienteConsultado1);
	}
	
	
	@Test
	public void excluirCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClientePostgres cliente = criarCliente();
		ClientePostgres retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClientePostgres clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException, MaisDeUmRegistroException, TableException, DAOException {
		ClientePostgres cliente = criarCliente();
		ClientePostgres retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClientePostgres clienteConsultado = clienteDao.consultar(cliente.getId());
		Assert.assertNotNull(clienteConsultado);
		
		clienteConsultado.setNome("Paulo H");
		clienteDao.alterar(clienteConsultado);
		
		ClientePostgres clienteAlterado = clienteDao.consultar(clienteConsultado.getId());
		Assert.assertNotNull(clienteAlterado);
		Assert.assertEquals("Paulo H", clienteAlterado.getNome());
		
		clienteDao.excluir(cliente);
		clienteConsultado = clienteDao.consultar(clienteAlterado.getId());
		Assert.assertNull(clienteConsultado);
	}
	
	@Test
	public void buscarTodos() throws TipoChaveNaoEncontradaException, DAOException {
		ClientePostgres cliente = criarCliente();
		ClientePostgres retorno = clienteDao.cadastrar(cliente);
		Assert.assertNotNull(retorno);
		
		ClientePostgres cliente1 = criarCliente();
		ClientePostgres retorno1 = clienteDao.cadastrar(cliente1);
		Assert.assertNotNull(retorno1);
		
		Collection<ClientePostgres> list = clienteDao.buscarTodos();
		assertTrue(list != null);
		assertTrue(list.size() == 2);
		
		list.forEach(cli -> {
			try {
				clienteDao.excluir(cli);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Collection<ClientePostgres> list1 = clienteDao.buscarTodos();
		assertTrue(list1 != null);
		assertTrue(list1.size() == 0);
	}
}
