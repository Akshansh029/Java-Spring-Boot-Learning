package com.akshansh.commands;

import com.akshansh.Task;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import picocli.CommandLine;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
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

            tasks.get(taskId - 1).setDesc(cleanDescription);

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
