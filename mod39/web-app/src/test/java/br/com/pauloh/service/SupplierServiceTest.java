package br.com.pauloh.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.pauloh.model.Supplier;

public class SupplierServiceTest {
    private static ISupplierService supplierService;
    private static Supplier supplier;

    @Before
    public void setup() {
        supplierService = new SupplierService();

        supplier = new Supplier();
        supplier.setName("test");
        supplier.setEmail("test@test");
        supplier.setPhone("111111111111");

        supplierService.create(supplier);
    }

    @After
    public void tearDown() {
        supplierService.delete(supplier.getId());
    }

    @Test
    public void createTest() {
        assertNotNull(supplier.getId());
    }

    @Test
    public void readTest() {
        assertNotNull(supplierService.read(supplier.getId()));
    }

    @Test
    public void updateTest() {
        supplier.setName("test2");
        supplierService.update(supplier);

        assertEquals(supplier.getName(), "test2");
    }

    @Test
    public void deleteTest() {
        supplierService.delete(supplier.getId());

        Supplier read = supplierService.read(supplier.getId());

        assertNull(read);
    }

}
