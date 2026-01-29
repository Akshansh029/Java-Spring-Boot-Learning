package com.akshansh;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class TasksDAO {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final File file = new File("data.json");

    public List<Task> getTaskList() {
        try {
            if (file.exists()) {
                try (FileReader fr = new FileReader(file)) {
                    JsonElement jsonElement = JsonParser.parseReader(fr);
                    if (jsonElement.isJsonObject()) {
                        JsonObject root = jsonElement.getAsJsonObject();
                        if (root.has("tasks")) {
                            Type taskListType = new TypeToken<List<Task>>(){}.getType();
                            return gson.fromJson(root.get("tasks"), taskListType);
                        }
                    }
                }
            }
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveTaskList(List<Task> tasks) throws IOException {
        JsonObject root = new JsonObject();
        root.add("tasks", gson.toJsonTree(tasks));

        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(root, fileWriter);
        }
    }

    public int getNextId() {
        List<Task> tasks = getTaskList();
        if (tasks.isEmpty()) {
            return 1;
        }

        // Find the maximum ID
        int maxId = tasks.stream()
                .mapToInt(Task::getId)
                .max()
                .orElse(0);

        return maxId + 1;
    }

    public Task getTaskById(int taskId) {
        List<Task> tasks = getTaskList();
        return tasks.stream()
                .filter(t -> t.getId() == taskId)
                .findFirst()
                .orElse(null);
    }

    public boolean updateTaskStatus(int taskId, Status newStatus) throws IOException {
        List<Task> tasks = getTaskList();

        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setStatus(newStatus);
                saveTaskList(tasks);
                return true;
            }
        }

        return false;  // Task not found
    }

    public boolean updateTaskDesc(int taskId, String desc) throws IOException {
        List<Task> tasks = getTaskList();

        for (Task task : tasks) {
            if (task.getId() == taskId) {
                task.setDesc(desc);
                saveTaskList(tasks);
                return true;
            }
        }

        return false;  // Task not found
    }

    public boolean removeTask(int taskId) throws IOException {
        List<Task> tasks = getTaskList();

        for (Task task : tasks) {
            if (task.getId() == taskId) {
                tasks.remove(task);
                saveTaskList(tasks);
                return true;
            }
        }

        return false;  // Task not found
    }

    public boolean removeTask(int taskId) throws IOException {
        List<Task> tasks = getTaskList();

        for (Task task : tasks) {
            if (task.getId() == taskId) {
                tasks.remove(task);
                saveTaskList(tasks);
                return true;
            }
        }

        return false;  // Task not found
    }
}