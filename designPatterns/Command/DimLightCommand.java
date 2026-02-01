package designPatterns.Command;


// Concrete Command 3
public class DimLightCommand implements CommandInterface {
    private final Light light;
    private final int dimLevel;
    private int previousBrightness; // Store for undo

    public DimLightCommand(Light light, int dimLevel) {
        this.light = light;
        this.dimLevel = dimLevel;
    }

    @Override
    public void executeCommand() {
        previousBrightness = light.getBrightness(); // Save state
        light.dim(dimLevel);
    }

    @Override
    public void undo() {
        light.dim(previousBrightness); // Restore previous state
    }
}
