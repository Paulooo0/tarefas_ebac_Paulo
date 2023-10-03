import cars.Car;
import cars.Hilux;
import cars.Savero;

public class WithContractFactory extends Factory{
    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new Savero(350, "cheio", "vermelho");
        } else {
            return new Hilux(400, "cheio", "branco");
        }
    }
}
