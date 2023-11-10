package br.com.pauloh.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import br.com.pauloh.dao.AccessoryDAO;
import br.com.pauloh.dao.BrandDAO;
import br.com.pauloh.dao.CarDAO;
import br.com.pauloh.dao.IAccessoryDAO;
import br.com.pauloh.dao.IBrandDAO;
import br.com.pauloh.dao.ICarDAO;

public class CarTest {
    private ICarDAO carDAO;
    private IBrandDAO brandDAO;
    private IAccessoryDAO accessoryDAO;

    public CarTest() {
        carDAO = new CarDAO();
        brandDAO = new BrandDAO();
        accessoryDAO = new AccessoryDAO();
    }

    public Brand createBrand(String code) {
        Brand brand = new Brand();

        brand.setCode(code);
        brand.setName("Honda");

        return brandDAO.create(brand);
    }

    public Accessory createAcessory(String code) {
        Accessory accessory = new Accessory();

        accessory.setCode(code);
        accessory.setName("Airbag");
        accessory.setPrice(200.0);

        return accessoryDAO.create(accessory);
    }

    @Test
    public void createCarTest() {
        Brand brand = createBrand("BRD1");
        Accessory accessory = createAcessory("ACC1");
        
        Car car = new Car();
        
        car.setCode("CAR1");
        car.setName("Civic");
        car.setPrice(70000.0);
        car.addAccessory(accessory);

        brand.addCar(car);

        car = carDAO.create(car);

        assertNotNull(car);
    }

    @Test
    public void readCarTest() {
        Brand brand = createBrand("BRD2");
        Accessory accessory = createAcessory("ACC2");
        
        Car car = new Car();
        
        car.setCode("CAR2");
        car.setName("Civic");
        car.setPrice(70000.0);
        car.addAccessory(accessory);

        brand.addCar(car);

        car = carDAO.create(car);

        Car findById = carDAO.read(car.getId());

        assertEquals(findById.getId(), car.getId());
    }

    @Test
    public void updateCarTest() {
        Brand brand = createBrand("BRD3");
        Accessory accessory = createAcessory("ACC3");
        
        Car car = new Car();
        
        car.setCode("CAR3");
        car.setName("Civic");
        car.setPrice(70000.0);
        car.addAccessory(accessory);
        brand.addCar(car);

        car = carDAO.create(car);

        car.setCode("CAR4");
        car.setName("Civic");
        car.setPrice(70000.0);
        car = carDAO.update(car);

        assertNotNull(car);
        assertNotNull(car.getId());
    }

    @Test
    public void deleteCarTest() {
        Brand brand = createBrand("BRD5");
        Accessory accessory = createAcessory("ACC5");
        
        Car car = new Car();
        
        car.setCode("CAR5");
        car.setName("Civic");
        car.setPrice(70000.0);
        car.addAccessory(accessory);
        brand.addCar(car);

        car = carDAO.create(car);

        carDAO.delete(car);

        Car deletedCar = carDAO.read(car.getId());
        assertNull(deletedCar);
    }
}
