package br.com.pauloh.dao.generic;

import java.io.Serializable;

import br.com.pauloh.dao.Persistente;

public class GenericDAOMySQL1<T extends Persistente, E extends Serializable> extends GenericDAO<T, E> {
    public GenericDAOMySQL1(Class<T> persistenteClass) {
		super(persistenteClass, "Mysql1");
	}
}
