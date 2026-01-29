package com.akshansh;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TasksDAO {
    private List<Task> tasks = new ArrayList<>();
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final File file = new File("data.json");


    public List<Task> getTaskList(){
        try{
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

            return tasks;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Gson getGson(){
        return gson;
    }

    public File getFile(){
        return file;
    }

    public Task getTaskById(int taskId){
        for(Task t : tasks){
            if(t.getId() == taskId) return t;
        }
        return null;
    }
}
