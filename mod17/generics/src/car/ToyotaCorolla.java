package car;

public class ToyotaCorolla<T> extends Car<T> {
    private String name = "Toyota Corolla";
    private String color = "Prateado";
    private String model = "2.0 GLi CVT";
    private Integer year = 2024;
    private Integer horsePower = 177;
    
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
