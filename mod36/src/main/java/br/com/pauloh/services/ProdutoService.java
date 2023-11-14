/**
 * 
 */
package br.com.pauloh.services;

import br.com.pauloh.dao.IProdutoDAO;
import br.com.pauloh.domain.Produto;
import br.com.pauloh.services.generic.GenericService;

/**
 * @author rodrigo.pires
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
