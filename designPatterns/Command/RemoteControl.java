package designPatterns.Command;
import java.util.Stack;


// Invoker - Remote Control
public class RemoteControl {
    private final Stack<CommandInterface> commandHistory = new Stack<>();

    public void pressButton(CommandInterface command) {
        command.executeCommand();
        commandHistory.push(command); // Store for undo
    }

    public void pressUndo() {
        if (commandHistory.isEmpty()) {
            System.out.println("Nothing to undo!");
            return;
        }

        CommandInterface lastCommand = commandHistory.pop();
        System.out.println("Undoing last command...");
        lastCommand.undo();
    }

    public void clearHistory() {
        commandHistory.clear();
        System.out.println("Command history cleared");
    }
}
