package com.akshansh.commands;

import com.akshansh.TasksDAO;
import com.google.gson.*;
import picocli.CommandLine;

import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "delete-all",
        description = "Delete all tasks"
)
public class DeleteAll implements Callable<Integer> {

    @Override
    public Integer call(){
        try {
            TasksDAO dao = new TasksDAO();

            // Find and remove the task
            if(dao.removeTask(taskId)){
                System.out.println("Task (ID: " + taskId + ") deleted successfully");
                return 0;
            } else{
                System.out.println("No task with ID: " + taskId);
                return 1;
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
