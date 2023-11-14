/**
 * 
 */
package br.com.pauloh.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.pauloh.dao.Persistente;
import br.com.pauloh.dao.generic.IGenericDAO;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.exceptions.MaisDeUmRegistroException;
import br.com.pauloh.exceptions.TableException;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public abstract class GenericService<T extends Persistente, E extends Serializable> 
	implements IGenericService<T, E> {
	
	protected IGenericDAO<T,E> dao;
	
	public GenericService(IGenericDAO<T,E> dao) {
		this.dao = dao;
	}

	@Override
	public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.cadastrar(entity);
	}

	@Override
	public void excluir(T entity) throws DAOException {
		this.dao.excluir(entity);
	}

	@Override
	public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		return this.dao.alterar(entity);
	}

	@Override
	public T consultar(E id) throws DAOException, MaisDeUmRegistroException, TableException {		
		return this.dao.consultar(id);
	}

	@Override
	public Collection<T> buscarTodos() throws DAOException {
		return this.dao.buscarTodos();
	}

}
