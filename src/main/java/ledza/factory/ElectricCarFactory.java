package ledza.factory;

import ledza.devices.Vehicle;
import ledza.devices.ElectricCar;

public class ElectricCarFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new ElectricCar();
    }
}
