package designPatterns.Command;

// Macro Command - Execute multiple commands
import java.util.ArrayList;
import java.util.List;

public class MacroCommand implements CommandInterface {
    private final List<CommandInterface> commands;

    public MacroCommand(List<CommandInterface> commands) {
        this.commands = new ArrayList<>(commands);
    }

    @Override
    public void executeCommand() {
        System.out.println("Executing macro with " + commands.size() + " commands...");
        for (CommandInterface command : commands) {
            command.executeCommand();
        }
    }

    @Override
    public void undo() {
        System.out.println("Undoing macro...");
        // Undo in reverse order
        for (int i = commands.size() - 1; i >= 0; i--) {
            commands.get(i).undo();
        }
    }
}