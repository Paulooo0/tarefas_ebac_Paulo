import java.util.ArrayList;
import java.util.List;

import car.FiatUno;
import car.HondaCivic;
import car.HyundaiHB20;
import car.ToyotaCorolla;
import car.ICar;
import car.Car;

public class App<T> extends Car<T> {
    public static void main(String[] args) throws Exception {
        List<ICar> cars = new ArrayList<>();

        FiatUno fiatUno = new FiatUno();
        HondaCivic hondaCivic = new HondaCivic();
        HyundaiHB20 hyundaiHB20 = new HyundaiHB20();
        ToyotaCorolla toyotaCorolla = new ToyotaCorolla();

        cars.add(fiatUno);
        cars.add(hondaCivic);
        cars.add(hyundaiHB20);
        cars.add(toyotaCorolla);
        
        printCarList(cars);
    }
}
