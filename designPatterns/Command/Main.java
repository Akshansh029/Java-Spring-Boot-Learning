package designPatterns.Command;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create receivers
        Light livingRoomLight = new Light("Living Room");
        Light bedroomLight = new Light("Bedroom");
        Thermostat thermostat = new Thermostat();

        // Create commands
        CommandInterface livingRoomOn = new LightOnCommand(livingRoomLight);
        CommandInterface livingRoomOff = new LightOffCommand(livingRoomLight);
        CommandInterface dimLivingRoom = new DimLightCommand(livingRoomLight, 30);
        CommandInterface bedroomOn = new LightOnCommand(bedroomLight);
        CommandInterface setTemp = new ThermostatCommand(thermostat, 68);

        // Create invoker
        RemoteControl remote = new RemoteControl();

        // Execute commands
        System.out.println("=== Turning on living room light ===");
        remote.pressButton(livingRoomOn);

        System.out.println("\n=== Dimming living room light ===");
        remote.pressButton(dimLivingRoom);

        System.out.println("\n=== Setting thermostat ===");
        remote.pressButton(setTemp);

        System.out.println("\n=== Undo last command (thermostat) ===");
        remote.pressUndo();

        System.out.println("\n=== Undo previous command (dim) ===");
        remote.pressUndo();

        // Macro command - "Good Night" mode
        System.out.println("\n=== Executing 'Good Night' macro ===");
        MacroCommand goodNightMacro = new MacroCommand(List.of(
                livingRoomOff,
                bedroomOn,
                new ThermostatCommand(thermostat, 65)
        ));
        remote.pressButton(goodNightMacro);

        System.out.println("\n=== Undo 'Good Night' macro ===");
        remote.pressUndo();
    }
}
