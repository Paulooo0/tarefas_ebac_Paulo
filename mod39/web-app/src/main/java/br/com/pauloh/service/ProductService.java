package br.com.pauloh.service;

import java.util.UUID;

import br.com.pauloh.model.Product;
import br.com.pauloh.service.generic.GenericService;

public class ProductService extends GenericService<Product, UUID> implements IProductService {

    public ProductService() {
        super(Product.class);
        new GenericService<>(Product.class);
    }
    
}
