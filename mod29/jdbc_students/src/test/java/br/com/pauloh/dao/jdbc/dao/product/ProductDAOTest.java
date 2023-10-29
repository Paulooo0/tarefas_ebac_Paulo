package br.com.pauloh.dao.jdbc.dao.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.pauloh.domain.Product;

public class ProductDAOTest {
    @Test
    public void testCreate() throws Exception {
        IProductDAO dao = new ProductDAO();
        Product product = new Product();

        product.setCode("01");
        product.setName("Produto 1");
        
        Integer qtd = dao.create(product);
        assertTrue(qtd == 1);

        Product productDB = dao.read(product.getCode());
        assertNotNull(productDB);
        assertNotNull(productDB.getId());
        assertEquals(product.getCode(), productDB.getCode());
        assertEquals(product.getName(), productDB.getName());

        Integer qtdDel = dao.delete(productDB);
        assertNotNull(qtdDel == 1);
    }

    @Test
    public void testUpdate() throws Exception {
        IProductDAO dao = new ProductDAO();
        Product product = new Product();

        product.setCode("01");
        product.setName("Produto 1");

        Integer qtd = dao.create(product);
        assertTrue(qtd == 1);

        Product product2 = product;
        product2.setName("Produto 1 - Atualizado");
        qtd = dao.update(product2);
        assertTrue(qtd == 1);

        Integer qtdDel = dao.delete(product);
        qtdDel += dao.delete(product2);
        assertNotNull(qtdDel == 2);
    }

    @Test
    public void testReadAll() throws Exception {
        IProductDAO dao = new ProductDAO();
        Product product = new Product();
        
        product.setCode("01");
        product.setName("Paulo Henrique");
        
        dao.create(product);

        List<Product> list = dao.readAll();
        assertNotNull(list);
        assertTrue(list.size() > 0);

        Integer qtdDel = dao.delete(product);
        assertNotNull(qtdDel == 1);
    }
}
