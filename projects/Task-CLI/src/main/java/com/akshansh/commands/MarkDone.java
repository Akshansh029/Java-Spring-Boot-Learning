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
        name = "mark-done",
        description = "Mark the task as done"
)
public class MarkDone implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "Task ID")
    private int taskId;

    @Override
    public Integer call(){
        try {
            TasksDAO dao = new TasksDAO();

            // Find and update the task status as done
            if(dao.updateTaskStatus(taskId, Status.DONE)){
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
