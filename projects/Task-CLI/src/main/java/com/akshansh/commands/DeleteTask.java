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
        name = "delete",
        description = "Delete a task"
)
public class DeleteTask implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "Task ID")
    private int taskId;

    @Override
    public Integer call(){
        try {
            TasksDAO dao = new TasksDAO();
            List<Task> tasks = dao.getTaskList();
            Gson gson = dao.getGson();
            File file = dao.getFile();

            // Initial check
            if(dao.getTaskById(taskId) != null){
                tasks.remove(dao.getTaskById(taskId));
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

            System.out.println("Task deleted successfully (ID: " + taskId + ")");
            return 0;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
