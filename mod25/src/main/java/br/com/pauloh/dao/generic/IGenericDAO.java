package br.com.pauloh.dao.generic;

import br.com.pauloh.dao.Persistent;
import br.com.pauloh.exception.TipoChaveNaoEncontradaException;

import java.util.Collection;

/**
 * @author rodrigo.pires
 *
 * Interface genérica para métodos de CRUD(Create, Read, Update and Delete)
 */
public interface IGenericDAO <T extends Persistent> {

    /**
     * Método para cadastrar novos registro no banco de dados
     *
     * @param entity a ser cadastrado
     * @return retorna verdadeiro para cadastrado e falso para não cadastrado
     */
    public Boolean save(T entity) throws TipoChaveNaoEncontradaException;

    /**
     * Método para excluir um registro do banco de dados
     *
     * @param valor chave única do dado a ser excluído
     */
    public void delete(Long valor);

    /**
     *Método para alterar um registro no bando de dados.
     *
     * @param entity a ser atualizado
     */
    public void update(T entity) throws TipoChaveNaoEncontradaException;

    /**
     * Método para consultar um registro no banco de dados
     *
     * @param valor chave única do dado a ser consultado
     * @return
     */
    public T findByCpf(Long valor);

    /**
     * Método que irá retornar todos os registros do banco de dados de uma determinado dado ou tabela
     *
     * @return Registros encontrados
     */
    public Collection<T> searchAll();
}