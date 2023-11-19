package br.com.pauloh.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.pauloh.model.Product;

public class ProductServiceTest {
    private static IProductService productService;
    private static Product product;

    @Before
    public void setup() {
        productService = new ProductService();

        product = new Product();
        product.setName("test");
        product.setBarCode("111111111111");
        product.setSupplier("test");

        productService.create(product);
    }

    @After
    public void tearDown() {
        productService.delete(product.getId());
    }

    @Test
    public void createTest() {
        assertNotNull(product.getId());
    }

    @Test
    public void readTest() {
        assertNotNull(productService.read(product.getId()));
    }

    @Test
    public void updateTest() {
        product.setName("test2");
        productService.update(product);

        assertEquals(product.getName(), "test2");
    }

    @Test
    public void deleteTest() {
        productService.delete(product.getId());

        Product read = productService.read(product.getId());

        assertNull(read);
    }
}
