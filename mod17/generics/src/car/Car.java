package car;

import java.util.List;

public abstract class Car<T> implements ICar<T> {

    @Override
    public String name(T entity) {
        return this.name(entity);    
    }

    @Override
    public String color(T entity) {
        return this.color(entity);
    }

    @Override
    public String model(T entity) {
        return this.model(entity);
    }

    @Override
    public Integer year(T value) {
        return this.year(value);
    }

    @Override
    public Integer horsePower(T value) {
        return this.horsePower(value);
    }
    
    protected static void printCarList(List<ICar> cars) {
        for (ICar car : cars) {
            System.out.println(car);
        }
    }
}
