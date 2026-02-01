package designPatterns.Command;

public class ThermostatCommand implements CommandInterface {
    private final Thermostat thermostat;
    private final int newTemperature;
    private int previousTemperature;

    public ThermostatCommand(Thermostat thermostat, int newTemperature) {
        this.thermostat = thermostat;
        this.newTemperature = newTemperature;
    }

    @Override
    public void executeCommand() {
        previousTemperature = thermostat.getTemperature();
        thermostat.setTemperature(newTemperature);
    }

    @Override
    public void undo() {
        thermostat.setTemperature(previousTemperature);
    }
}