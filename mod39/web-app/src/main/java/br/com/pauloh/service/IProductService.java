package br.com.pauloh.service;

import java.util.UUID;

import br.com.pauloh.model.Product;
import br.com.pauloh.service.generic.IGenericService;

public interface IProductService extends IGenericService<Product, UUID> {

}
