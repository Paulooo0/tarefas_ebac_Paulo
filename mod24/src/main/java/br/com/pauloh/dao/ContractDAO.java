package br.com.pauloh.dao;

public class ContractDAO implements IContractDAO {

    @Override
    public void save() {
        throw new UnsupportedOperationException("Nao funciona sem implementacao");
    }

    @Override
    public void search() {
        throw new UnsupportedOperationException("Nao foi possivel fazer a busca");
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Nao foi possivel atualizar");
    }

    @Override
    public void delete() {
        throw new UnsupportedOperationException("Nao foi possivel deletar");
    }


}
