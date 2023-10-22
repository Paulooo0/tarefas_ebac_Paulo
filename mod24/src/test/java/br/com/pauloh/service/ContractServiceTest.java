package br.com.pauloh.service;

import org.junit.Assert;
import org.junit.Test;

import br.com.pauloh.dao.ContractDAO;
import br.com.pauloh.dao.IContractDAO;
import br.com.pauloh.mock.ContractDAOMock;

public class ContractServiceTest {
    @Test
    public void testSave() {
        IContractDAO dao = new ContractDAOMock();
        IContractService service = new ContractService(dao);
        String success = service.save();
        Assert.assertEquals("Sucesso", success);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSaveDBError() {
        IContractDAO dao = new ContractDAO();
        IContractService service = new ContractService(dao);
        String success = service.save();
        Assert.assertEquals("Sucesso", success);
    }

    @Test
    public void testSearch() {
        IContractDAO dao = new ContractDAOMock();
        IContractService service = new ContractService(dao);
        String success = service.search();
        Assert.assertEquals("Sucesso", success);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testSearchError() {
        IContractDAO dao = new ContractDAO();
        IContractService service = new ContractService(dao);
        String success = service.search();
        Assert.assertEquals("Sucesso", success);
    }

    @Test
    public void testUpdate() {
        IContractDAO dao = new ContractDAOMock();
        IContractService service = new ContractService(dao);
        String success = service.update();
        Assert.assertEquals("Sucesso", success);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUpdateError() {
        IContractDAO dao = new ContractDAO();
        IContractService service = new ContractService(dao);
        String success = service.update();
        Assert.assertEquals("Sucesso", success);
    }

    @Test
    public void testDelete() {
        IContractDAO dao = new ContractDAOMock();
        IContractService service = new ContractService(dao);
        String success = service.delete();
        Assert.assertEquals("Sucesso", success);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testDeleteError() {
        IContractDAO dao = new ContractDAO();
        IContractService service = new ContractService(dao);
        String success = service.delete();
        Assert.assertEquals("Sucesso", success);
    }
}
