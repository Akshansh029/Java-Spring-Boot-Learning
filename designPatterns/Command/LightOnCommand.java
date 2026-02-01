package designPatterns.Command;

public class LightOnCommand implements CommandInterface {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void executeCommand() {
        light.on();
    }

    @Override
    public void undo() {
        light.off(); // Reverse operation
    }
}
