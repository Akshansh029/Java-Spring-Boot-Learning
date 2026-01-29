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
        name = "mark-in-progress",
        description = "Mark the task as in-progress"
)
public class MarkInProgress implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "Task ID")
    private int taskId;

    @Override
    public Integer call(){
        try {
            TasksDAO dao = new TasksDAO();

            // Find and update the task status as in-progress
            if(dao.updateTaskStatus(taskId, Status.IN_PROGRESS)){
                System.out.println("Task (ID: " + taskId + ") marked in-progress");
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
