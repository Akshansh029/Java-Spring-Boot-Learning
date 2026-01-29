package com.akshansh.commands;

import com.akshansh.Status;
import com.akshansh.Task;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import picocli.CommandLine;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            File file = new File("data.json");

            // Read existing tasks or initialize
            List<Task> tasks = new ArrayList<>();

            if(file.exists()){
                try(FileReader fr = new FileReader(file)){
                    JsonElement jsonElement = JsonParser.parseReader(fr);
                    if(jsonElement.isJsonObject()){
                        JsonObject root = jsonElement.getAsJsonObject();
                        if(root.has("tasks")){
                            Type taskListType = new TypeToken<List<Task>>(){}.getType();
                            tasks = gson.fromJson(root.get("tasks"), taskListType);
                        }
                    }
                }
            }

            // Initial check
            if(taskId > tasks.size()){
                System.out.println("No task with ID: " + taskId);
                return 1;
            }

            // Updating task status
            tasks.get(taskId - 1).setStatus(Status.IN_PROGRESS);

            JsonObject root = new JsonObject();
            root.add("tasks", gson.toJsonTree(tasks));

            // Write back to file
            try (FileWriter fileWriter = new FileWriter(file)) {
                gson.toJson(root, fileWriter);
            }

            System.out.println("Task marked in progress (ID: " + taskId + ")");
            return 0;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
