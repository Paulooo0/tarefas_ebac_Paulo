/**
 * 
 */
package br.com.pauloh.dao;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.ClientePostgres;
import br.com.pauloh.domain.Produto;
import br.com.pauloh.domain.Venda;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class VendaDAO extends GenericDAO<Venda, Long> implements IVendaDAO {
	
	public VendaDAO() {
		super(Venda.class);
	}

	@Override
	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	@Override
	public void cancelarVenda(Venda venda) throws TipoChaveNaoEncontradaException, DAOException {
		super.alterar(venda);
	}

	@Override
	public void excluir(Venda entity) throws DAOException {
		throw new UnsupportedOperationException("OPERAÇÃO NÃO PERMITIDA");
	}

	@Override
	public Venda cadastrar(Venda entity) throws TipoChaveNaoEncontradaException, DAOException {
		try {
			openConnection();
			entity.getProdutos().forEach(prod -> {
				Produto product = em.merge(prod.getProduto());
				prod.setProduto(product);
			});
			ClientePostgres cliente = em.merge(entity.getCliente());
			entity.setCliente(cliente);
			em.persist(entity);
			em.getTransaction().commit();
			closeConnection();
			return entity;
		} catch (Exception e) {
			throw new DAOException("ERRO SALVANDO VENDA ", e);
		}
		
	}

	public Venda consultarComCollection(Long id) {
		openConnection();
		
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Venda> query = builder.createQuery(Venda.class);
		Root<Venda> root = query.from(Venda.class);
		root.fetch("cliente");
		root.fetch("produtos");
		query.select(root).where(builder.equal(root.get("id"), id));
		TypedQuery<Venda> tpQuery = 
				em.createQuery(query);
		Venda venda = tpQuery.getSingleResult();   
		closeConnection();
		return venda;
	}
}
