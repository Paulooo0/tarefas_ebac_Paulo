package br.com.pauloh.service;

import br.com.pauloh.dao.IContractDAO;

public class ContractService implements IContractService {
    private IContractDAO contractDAO;

    public ContractService(IContractDAO dao) {
        this.contractDAO = dao;
    }

    @Override
    public String save() {
        contractDAO.save();
        return "Sucesso";
    }

    @Override
    public String search() {
        contractDAO.search();
        return "Sucesso";
    }

    @Override
    public String update() {
        contractDAO.update();
        return "Sucesso";
    }

    @Override
    public String delete() {
        contractDAO.delete();
        return "Sucesso";
    }
}
