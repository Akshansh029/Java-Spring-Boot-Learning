package com.akshansh.commands;

import com.akshansh.Task;
import com.akshansh.TasksDAO;
import com.google.gson.*;
import picocli.CommandLine;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "delete-all",
        description = "Delete all tasks"
)
public class DeleteAll implements Callable<Integer> {

    @Override
    public Integer call(){
        try {
            TasksDAO dao = new TasksDAO();
            dao.saveTaskList(new ArrayList<Task>());

            System.out.println("All tasks removed successfully");
            return 0;
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
