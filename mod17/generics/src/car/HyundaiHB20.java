package car;

public class HyundaiHB20<T> extends Car<T> {
    private String name = "Hyundai HB20";
    private String color = "Azul escuro";
    private String model = "1.0 Sense";
    private Integer year = 2024;
    private Integer horsePower = 80;
    
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
