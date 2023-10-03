import cars.Car;

public class App {
    public static void main(String[] args) {
        Customer cliente = new Customer("A", false);
        Factory factory = getFactory(cliente);
        Car car = factory.create(cliente.getGradeRequest());
        car.startEngine();
    }

    private static Factory getFactory(Customer cliente) {
        if (cliente.hasCompanyContract()) {
            return new WithContractFactory();
        } else {
            return new WithoutContractFactory();
        }
    }
}
