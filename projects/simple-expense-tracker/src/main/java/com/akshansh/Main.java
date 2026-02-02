package com.akshansh;

import com.akshansh.commands.AddExpense;
import com.akshansh.commands.ListExpenses;
import picocli.CommandLine;

import java.util.Scanner;

@CommandLine.Command(
        name = "expense-tracker",
        description = "Manage your expenses",
        subcommands = {
                AddExpense.class,
                ListExpenses.class
        }
)
public class Main implements Runnable{
    @CommandLine.Option(names = {"-i", "--interactive"}, description = "Run in interactive mode")
    private boolean interactive;

    @Override
    public void run() {
        if (interactive) {
            runInteractiveMode();
        } else {
            System.out.println("Manage your expenses efficiently!");
            System.out.println("Usage: expense-tracker -i  (for interactive mode)");
        }
    }

    private void runInteractiveMode() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Expense Tracker Interactive Mode ===");
        System.out.println("Available commands: add, list, summary, update, delete, delete-all, exit");

        while (true) {
            System.out.print("\nexpense-tracker> ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
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
        // Simple parsing
        return input.split("\\s+(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new Main()).execute(args);
        System.exit(exitCode);
    }
}
