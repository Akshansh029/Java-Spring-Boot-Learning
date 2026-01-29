package com.akshansh.commands;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.akshansh.Status;
import com.akshansh.Task;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import picocli.CommandLine;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "list",
        description = "List all tasks"
)
public class ListTasks implements Callable<Integer> {
    @CommandLine.Parameters(index = "0", description = "Task Status", defaultValue = "all")
    private String taskStatus;

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

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

            if(taskStatus.equals("all")){
                tasks.forEach(t -> {
                    System.out.println("Task ID: " + t.getId() + ", Description: " + t.getDesc() + ", Status: " + t.getStatus() + ", createdAt: " + formatter.format(t.getCreatedAt()));
                });
            } else{
                if(Status.checkStatus(taskStatus)){
                    tasks.stream()
                            .filter(t -> t.getStatus().getStat().equals(taskStatus))
                            .forEach(t -> {
                                System.out.println("Task ID: " + t.getId() + ", Description: " + t.getDesc() + ", Status: " + t.getStatus() + ", createdAt: " + formatter.format(t.getCreatedAt()));
                            });
                } else{
                    System.out.println("Wrong status type, please check again");
                    return 1;
                }
            }
            return 0;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
