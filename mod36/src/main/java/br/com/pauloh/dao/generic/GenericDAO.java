package br.com.pauloh.dao.generic;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.postgresql.core.ConnectionFactory;

import br.com.pauloh.dao.Persistente;
import br.com.pauloh.exceptions.DAOException;
import br.com.pauloh.exceptions.MaisDeUmRegistroException;
import br.com.pauloh.exceptions.TableException;
import br.com.pauloh.exceptions.TipoChaveNaoEncontradaException;

public abstract class GenericDAO<T extends Persistente, E extends Serializable> implements IGenericDAO<T,E> {

	protected EntityManagerFactory emf;
	protected EntityManager em;
	private Class<T> persistenceClass;

	private static final String PERSISTENCE_UNIT_NAME = "Postgre1";
	private String persistenceUnitName;

	public GenericDAO(Class<T> persistenceClass, String persistenceUnitName) {
		this.persistenceClass = persistenceClass;
		this.persistenceUnitName = persistenceUnitName;
	}

	public GenericDAO(Class<T> persistenceClass) {
		this.persistenceClass = persistenceClass;
	}

    @Override
    public T cadastrar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
    	openConnection();
		em.persist(entity);
		em.getTransaction().commit();
		closeConnection();
		
		return entity;
    }

	
	@Override
    public void excluir(T entity) throws DAOException {
		openConnection();
		entity = em.merge(entity);
		em.remove(entity);
		em.getTransaction().commit();
		closeConnection();
    }

    @Override
    public T alterar(T entity) throws TipoChaveNaoEncontradaException, DAOException {
		openConnection();
		entity = em.merge(entity);
		em.getTransaction().commit();
		closeConnection();
		
		return entity;
    	
    }

    @Override
	public T consultar(E id) throws MaisDeUmRegistroException, TableException, DAOException {
    	openConnection();
		T entity = em.find(persistenceClass, id);
		em.getTransaction().commit();
		closeConnection();
		return entity;
    }

	@Override
    public Collection<T> buscarTodos() throws DAOException {
		openConnection();

        List<T> entities = em
		.createQuery(getSelectSQL(), persistenceClass)
		.getResultList();
        
        closeConnection();
        return entities;
    }

	protected void openConnection() {
		em.close();
		emf.close();
	}
	
	protected void closeConnection() {
		emf = Persistence.createEntityManagerFactory("ExemploJPA");
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}

	protected String getSelectSQL() {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT obj FROM ");
		sb.append(persistenceClass.getSimpleName());
		sb.append(" obj");

		return sb.toString();
	}

}
