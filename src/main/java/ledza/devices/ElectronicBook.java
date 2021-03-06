package ledza.devices;

public class ElectronicBook extends Vehicle {

    public ElectronicBook() {
        setType("Electronic Book");
    }

    @Override
    public String toString() {
        return "Console{" +
                "type='" + getType() + '\'' +
                ", EnginePower=" + getEnginePower() +
                ", SeatsAmount=" + getSeatsAmount() +
                "}\n";    }
}
