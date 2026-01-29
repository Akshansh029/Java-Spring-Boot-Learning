package com.akshansh.commands;

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
        String cleanDescription = taskDescription;
        if (cleanDescription.startsWith("\"") && cleanDescription.endsWith("\"")) {
            cleanDescription = cleanDescription.substring(1, cleanDescription.length() - 1);
        }

        try {
            TasksDAO dao = new TasksDAO();
            List<Task> tasks = dao.getTaskList();
            Gson gson = dao.getGson();
            File file = dao.getFile();

            // Initial check
            if(dao.getTaskById(taskId) != null){
                dao.getTaskById(taskId).setDesc(cleanDescription);
            } else{
                System.out.println("No task with ID: " + taskId);
                return 1;
            }

            JsonObject root = new JsonObject();
            root.add("tasks", gson.toJsonTree(tasks));

            // Write back to file
            try (FileWriter fileWriter = new FileWriter(file)) {
                gson.toJson(root, fileWriter);
            }

            System.out.println("Task updated successfully (ID: " + taskId + ")");
            return 0;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
