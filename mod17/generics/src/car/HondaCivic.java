package car;

public class HondaCivic<T> extends Car<T> {
    private String name = "Honda Civic";
    private String color = "Preto";
    private String model = "2.0 Híbrido Touring e-CVT";
    private Integer year = 2023;
    private Integer horsePower = 143;
    
    public String getName() {
        return name;
    }
    public String getColor() {
        return color;
    }
    public String getModel() {
        return model;
    }
    public Integer getYear() {
        return year;
    }
    public Integer getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return name + ", cor: " + color + ", modelo: " + model + ", ano: " + year +
        ", potência: " + horsePower;
    }
}
