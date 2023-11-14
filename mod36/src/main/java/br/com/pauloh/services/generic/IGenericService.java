/**
 * 
 */
package br.com.pauloh.services.generic;

import java.io.Serializable;
import java.util.Collection;

import br.com.pauloh.dao.Persistente;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.exceptions.MaisDeUmRegistroException;
import br.com.pauloh.exceptions.TableException;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author rodrigo.pires
 *
 */
public interface IGenericService <T extends Persistente, E extends Serializable> {
	
	/**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param entity a ser cadastrado
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
	 * @throws DAOException 
     */
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para excluir um registro do banco de dados
     *
     * @param id chave única do dado a ser excluído
     * @throws DAOException 
     */
    public void excluir(T entity) throws DAOException;

    /**
     *Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     * @throws DAOException 
     */
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException;

    /**
     * Método para consultar um registro no banco de dados
     *
     * @param id chave única do dado a ser consultado
     * @return
     * @throws DAOException 
     * @throws TableException
     * @throws MaisDeUmRegistroException
     */
    public T consultar(E id) throws DAOException, MaisDeUmRegistroException, TableException;

    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     * @throws DAOException 
     */
    public Collection<T> buscarTodos() throws DAOException;

}
