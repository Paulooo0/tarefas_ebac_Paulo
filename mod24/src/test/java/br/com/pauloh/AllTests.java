package br.com.pauloh;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.com.pauloh.service.ClientServiceTest;
import br.com.pauloh.service.ContractServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ClientServiceTest.class, ContractServiceTest.class})
public class AllTests {
    
}
