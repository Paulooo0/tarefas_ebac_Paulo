/**
 * 
 */
package br.com.pauloh.dao;

import java.util.Collection;

import br.com.pauloh.domain.Produto;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoDaoMock implements IProdutoDAO {

	@Override
	public Produto cadastrar(Produto entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Produto entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Produto alterar(Produto entity) throws TipoChaveNaoEncontradaException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produto consultar(String code) {
		Produto produto = new Produto();
		produto.setCodigo(code);
		return produto;
	}

	@Override
	public Collection<Produto> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}
