package br.com.pauloh.dao;

import br.com.pauloh.dao.generics.GenericDAO;
import br.com.pauloh.domain.Brand;

public class BrandDAO extends GenericDAO<Brand> implements IBrandDAO {
    public BrandDAO() {
        super(Brand.class);
        new GenericDAO<>(Brand.class);
    }
}
