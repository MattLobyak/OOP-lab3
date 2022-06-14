package ledza.factory;

import ledza.devices.Vehicle;
import ledza.devices.ElectronicBook;

public class ElectronicBookFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new ElectronicBook();
    }
}
