package car;

public class FiatUno<T> extends Car<T> {
    private String name = "Fiat Uno";
    private String color = "Prateado";
    private String model = "Drive Firefly 1.0 (Flex)";
    private Integer year = 2021;
    private Integer horsePower = 77;
    
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
