package com.akshansh.commands;

import com.akshansh.TasksDAO;
import com.google.gson.*;
import com.akshansh.Status;
import com.akshansh.Task;
import picocli.CommandLine;

import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "add",
        description = "Add a new task"
)
public class AddTask implements Callable<Integer> {

    @CommandLine.Parameters(index = "0", description = "The task description")
    private String taskDescription;

    @Override
    public Integer call() {
        String cleanDescription = taskDescription;
        if (cleanDescription.startsWith("\"") && cleanDescription.endsWith("\"")) {
            cleanDescription = cleanDescription.substring(1, cleanDescription.length() - 1);
        }

        try {
            TasksDAO dao = new TasksDAO();
            List<Task> tasks = dao.getTaskList();

            // New task
            Task newTask = new Task(dao.getNextId(), cleanDescription, Status.TODO, new Date(), new Date());

            // Adding task object to tasks list in JSON
            tasks.add(newTask);

            dao.saveTaskList(tasks);

            System.out.println("Task added successfully (ID: " + newTask.getId() + ")");
            return 0;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}