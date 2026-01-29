package com.akshansh.commands;

import com.akshansh.Status;
import com.akshansh.Task;
import com.akshansh.TasksDAO;
import com.google.gson.*;
import picocli.CommandLine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "update",
        description = "Update a task"
)
public class UpdateTask implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "Task ID")
    private int taskId;

    @CommandLine.Parameters(index = "1", description = "Task description")
    private String taskDescription;

    @Override
    public Integer call(){
        // Remove /"
        if (taskDescription.startsWith("\"") && taskDescription.endsWith("\"")) {
            taskDescription = taskDescription.substring(1, taskDescription.length() - 1);
        }

        try {
            TasksDAO dao = new TasksDAO();
            List<Task> tasks = dao.getTaskList();

            // Find and update the task description
            if(dao.updateTaskDesc(taskId, taskDescription)){
                System.out.println("Task (ID: " + taskId + ") marked done. Good job!");
                return 0;
            } else{
                System.out.println("No task with ID: " + taskId);
                return 1;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
