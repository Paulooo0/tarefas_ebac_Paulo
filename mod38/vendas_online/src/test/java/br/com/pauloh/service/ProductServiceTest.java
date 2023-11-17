package br.com.pauloh.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.After;
import org.junit.Test;

import br.com.pauloh.model.Product;

public class ProductServiceTest {
    IProductService productService;

    public ProductServiceTest() {
        productService = new ProductService();
    }

    @After
    public void after() {
        List<Product> products = productService.searchAll();
        for (Product product : products) {
            productService.delete(product.getId());
        }
    }

    @Test
    public void testCreate() {
        Product product = new Product();
        product.setName("Teste");
        product.setPrice(100.00);
        product.setDescription("test");
        
        productService.create(product);

        assertNotNull(product.getId());
    }

    @Test
    public void testDelete() {
        Product product = new Product();
        product.setName("Teste");
        product.setPrice(100.00);
        product.setDescription("test");

        productService.create(product);

        productService.delete(product.getId());

        assertNotNull(product.getId());
    }

    @Test
    public void testRead() {
        Product product = new Product();
        product.setName("Teste");
        product.setPrice(100.00);
        product.setDescription("test");

        productService.create(product);
        Product read = productService.read(product.getId());

        assertNotNull(read);
    }

    @Test
    public void testUpdate() {
        Product product = new Product();
        product.setName("Teste");
        product.setPrice(100.00);
        product.setDescription("test");

        productService.create(product);

        product.setName("Teste2");
        productService.update(product);

        assertEquals("Teste2", product.getName());
    }
}
