package ledza.factory;

import ledza.devices.Vehicle;
import ledza.devices.CompanyCar;

public class CompanyCarFactory implements AbstractFactory{
    @Override
    public Vehicle createObj() {
        return new CompanyCar();
    }
}
