package ledza.factory;

import ledza.devices.Vehicle;
import ledza.devices.Motorbike;

public class MotorbikeFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new Motorbike();
    }
}
