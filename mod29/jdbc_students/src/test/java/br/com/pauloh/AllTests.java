package br.com.pauloh;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.pauloh.dao.jdbc.dao.client.ClientDAOTest;
import br.com.pauloh.dao.jdbc.dao.product.ProductDAOTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ClientDAOTest.class, ProductDAOTest.class})
public class AllTests {
    
}
