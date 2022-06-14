package ledza.factory;

import ledza.devices.Passenger;
import ledza.devices.Vehicle;

public class PassengerFactory implements AbstractFactory {

    @Override
    public Vehicle createObj() {
        return new Passenger();
    }
}
