package designPatterns.Command;

// Receiver 2 - Thermostat
public class Thermostat {
    private int temperature = 72; // Default 72°F

    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Thermostat set to " + temp + "°F");
    }

    public int getTemperature() {
        return temperature;
    }
}
