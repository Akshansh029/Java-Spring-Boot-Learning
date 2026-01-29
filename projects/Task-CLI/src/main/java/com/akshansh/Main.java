package com.akshansh;

import com.akshansh.commands.*;
import picocli.CommandLine;

import java.util.Scanner;

@CommandLine.Command(
        name = "task-cli",
        description = "Handles todo list",
        subcommands = {AddTask.class,
                       UpdateTask.class,
                       DeleteTask.class,
                       ListTasks.class,
                       MarkInProgress.class,
                       MarkDone.class,
                       DeleteAll.class
        }
)
public class Main implements Runnable {

    @CommandLine.Option(names = {"-i", "--interactive"}, description = "Run in interactive mode")
    private boolean interactive;

    @Override
    public void run() {
        if (interactive) {
            runInteractiveMode();
        } else {
            System.out.println("Task-CLI handles your tasks efficiently!");
            System.out.println("Usage: task-cli -i  (for interactive mode)");
        }
    }

    private void runInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Task CLI Interactive Mode ===");
        System.out.println("Available commands: add, list, update, delete, delete-all, exit");

        while (true) {
            System.out.print("\ntask-cli> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit") || input.equalsIgnoreCase("quit")) {
                System.out.println("Goodbye!");
                break;
            }

            if (input.isEmpty()) {
                continue;
            }

            // Parse and execute the command
            String[] args = parseInput(input);
            int exitCode = new CommandLine(new Main()).execute(args);

            if (exitCode != 0) {
                System.out.println("Command failed. Try again.");
            }
        }
        scanner.close();
    }

    private String[] parseInput(String input) {
        // Simple parsing - you might want to use a proper parser for quoted strings
        return input.split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}