package designPatterns.Command;


// Concrete Command 2 - Light Off
public class LightOffCommand implements CommandInterface {
    private final designPatterns.Command.Light light;

    public LightOffCommand(designPatterns.Command.Light light) {
        this.light = light;
    }

    @Override
    public void executeCommand() {
        light.off();
    }

    @Override
    public void undo() {
        light.on(); // Reverse operation
    }
}
