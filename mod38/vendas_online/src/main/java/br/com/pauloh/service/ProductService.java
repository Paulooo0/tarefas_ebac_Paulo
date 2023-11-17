package br.com.pauloh.service;

import br.com.pauloh.model.Product;
import br.com.pauloh.service.generic.GenericService;

public class ProductService extends GenericService<Product> implements IProductService {

    public ProductService() {
        super(Product.class);
        new GenericService<>(Product.class);
    }
    
}
