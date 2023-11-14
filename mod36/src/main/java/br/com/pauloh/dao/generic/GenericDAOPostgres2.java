package br.com.pauloh.dao.generic;

import java.io.Serializable;

import br.com.pauloh.dao.Persistente;

public class GenericDAOPostgres2<T extends Persistente, E extends Serializable> extends GenericDAO<T, E> {
    public GenericDAOPostgres2(Class<T> persistenteClass) {
		super(persistenteClass, "Postgre2");
	}
}
