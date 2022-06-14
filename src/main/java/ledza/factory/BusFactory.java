package ledza.factory;

import ledza.devices.Bus;
import ledza.devices.Vehicle;

public class BusFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Bus();
    }
}
