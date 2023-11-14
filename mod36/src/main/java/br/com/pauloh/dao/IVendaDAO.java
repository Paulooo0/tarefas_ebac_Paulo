/**
 * 
 */
package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.IGenericDAO;
import br.com.pauloh.domain.Venda;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, Long> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;
	
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException;

	public Venda consultarComCollection(Long id);
}
