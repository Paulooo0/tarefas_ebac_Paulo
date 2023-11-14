/**
 * 
 */
package br.com.pauloh.dao;

import br.com.pauloh.dao.generic.IGenericDAO;

/**
 * @author rodrigo.pires
 *
 */
public interface IClienteDAO<T extends Persistente> extends IGenericDAO<T, Long> {


}
