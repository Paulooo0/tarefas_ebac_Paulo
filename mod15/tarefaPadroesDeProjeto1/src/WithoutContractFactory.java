import cars.Car;
import cars.Celta;
import cars.Corsa;

public class WithoutContractFactory extends Factory {
    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Corsa(350, "cheio", "azul");
        } else {
            return new Celta(300, "cheio", "preto");
        }
    }
}
