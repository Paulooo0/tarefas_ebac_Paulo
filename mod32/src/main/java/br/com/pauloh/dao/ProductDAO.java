package br.com.pauloh.dao;

import java.util.List;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Product;

public class ProductDAO extends GenericDAO<Product> implements IProductDAO {
    private GenericDAO<Product> genericDAO;

    public ProductDAO() {
        super();
        this.genericDAO = new GenericDAO<>(Product.class);
    }

    @Override
    public Product create(Product entity) {
        return genericDAO.create(entity);
    }

    @Override
    public Product update(Product entity) {
        return genericDAO.update(entity);
    }

    @Override
    public void delete(Product entity) {
        genericDAO.delete(entity);
    }

    @Override
    public Product findById(Long id) {
        return genericDAO.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return genericDAO.findAll();
    }
}
