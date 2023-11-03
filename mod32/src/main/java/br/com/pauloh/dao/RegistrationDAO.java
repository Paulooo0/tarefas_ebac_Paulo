package br.com.pauloh.dao;

import java.util.List;

import br.com.pauloh.dao.generic.GenericDAO;
import br.com.pauloh.domain.Registration;

public class RegistrationDAO extends GenericDAO<Registration> implements IRegistrationDAO {
    private GenericDAO<Registration> genericDAO;

    public RegistrationDAO() {
        super();
        this.genericDAO = new GenericDAO<>(Registration.class);
    }

    public RegistrationDAO(GenericDAO<Registration> genericDAO) {
        this.genericDAO = genericDAO;
    }

    @Override
    public Registration create(Registration entity) {
        return genericDAO.create(entity);
    }

    @Override
    public Registration update(Registration entity) {
        return genericDAO.update(entity);
    }

    @Override
    public void delete(Registration entity) {
        genericDAO.delete(entity);
    }

    @Override
    public Registration findById(Long id) {
        return genericDAO.findById(id);
    }

    @Override
    public List<Registration> findAll() {
        return genericDAO.findAll();
    }
}
