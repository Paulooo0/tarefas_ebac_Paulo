package br.com.pauloh.dao.jdbc.dao.product;

import java.util.List;

import br.com.pauloh.domain.Product;

public interface IProductDAO {
    public Integer create(Product product) throws Exception;

    public Product read(String code) throws Exception;

    public Integer update(Product product) throws Exception;

    public Integer delete(Product product) throws Exception;

    public List<Product> readAll() throws Exception;
}
