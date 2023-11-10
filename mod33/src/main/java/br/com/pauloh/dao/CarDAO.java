package br.com.pauloh.dao;

import br.com.pauloh.dao.generics.GenericDAO;
import br.com.pauloh.domain.Car;

public class CarDAO extends GenericDAO<Car> implements ICarDAO {
    public CarDAO() {
        super(Car.class);
        new GenericDAO<>(Car.class);
    }
}
