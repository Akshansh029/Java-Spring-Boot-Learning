package com.akshansh;

import picocli.CommandLine;

@CommandLine.Command(
        name = "task-cli",
        description = "Handles todo list"
)
public class TaskCLICommand implements Runnable {
    @CommandLine.Command(name = "add")
    public void addCommand() {
        System.out.println("Adding tasks in JSON");
    }

    @CommandLine.Command(name = "update")
    public void updateCommand() {
        System.out.println("Updating tasks in JSON");
    }

    @CommandLine.Command(name = "delete")
    public void deleteCommand() {
        System.out.println("Deleting the task...");
    }

    @CommandLine.Command(name = "mark-in-progress")
    public void markProgressCommand() {
        System.out.println("Marking the progress of the task...");
    }

    @CommandLine.Command(name = "list")
    public void listTasksCommand() {
        System.out.println("Listing the tasks...");
    }

    @Override
    public void run(){
        System.out.println("Task-CLI handles your tasks efficiently!");
    }

    public static void main(String[] args) {
        CommandLine.run(new TaskCLICommand(), args);
    }
}
