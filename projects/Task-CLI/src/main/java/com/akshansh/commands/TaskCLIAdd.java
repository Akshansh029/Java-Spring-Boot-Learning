package com.akshansh.commands;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.akshansh.Status;
import com.akshansh.Task;
import picocli.CommandLine;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "add",
        description = "Add a new task"
)
public class TaskCLIAdd implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The task description")
    private String taskDescription;

    @Override
    public Integer call() {
        // New Task to  be added
        String cleanDescription = taskDescription;
        if (cleanDescription.startsWith("\"") && cleanDescription.endsWith("\"")) {
            cleanDescription = cleanDescription.substring(1, cleanDescription.length() - 1);
        }

        Task t = new Task(cleanDescription, Status.TODO, new Date(), new Date());

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

            // Adding task object to tasks list in JSON
            tasks.add(t);

            JsonObject root = new JsonObject();
            root.add("tasks", gson.toJsonTree(tasks));

            // Write back to file
            try (FileWriter fileWriter = new FileWriter(file)) {
                gson.toJson(root, fileWriter);
            }

            System.out.println("Task added successfully (ID: " + t.getId() + ")");
            return 0;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}