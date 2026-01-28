package com.akshansh;

import com.akshansh.commands.TaskCLIAdd;
import picocli.CommandLine;

@CommandLine.Command(
        name = "task-cli",
        description = "Handles todo list",
        subcommands = {
                TaskCLIAdd.class
        }
)
public class TaskCLICommand implements Runnable {

    @Override
    public void run(){
        System.out.println("Task-CLI handles your tasks efficiently!");
    }

    public static void main(String[] args) {
        CommandLine.run(new TaskCLICommand(), args);
    }
}
