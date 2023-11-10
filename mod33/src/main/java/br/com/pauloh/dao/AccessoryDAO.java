package br.com.pauloh.dao;

import br.com.pauloh.dao.generics.GenericDAO;
import br.com.pauloh.domain.Accessory;

public class AccessoryDAO extends GenericDAO<Accessory> implements IAccessoryDAO {
    public AccessoryDAO() {
        super(Accessory.class);
        new GenericDAO<>(Accessory.class);
    }
}
