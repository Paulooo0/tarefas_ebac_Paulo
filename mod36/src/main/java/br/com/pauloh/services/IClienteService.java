/**
 * 
 */
package br.com.pauloh.services;

import br.com.pauloh.domain.ClientePostgres;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.services.generic.IGenericService;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteService extends IGenericService<ClientePostgres, Long> {

//	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;
//
	ClientePostgres buscarPorCPF(Long cpf) throws DAOException;
//
//	void excluir(Long cpf);
//
//	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
