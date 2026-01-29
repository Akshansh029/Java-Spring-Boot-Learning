package com.akshansh.commands;

import java.text.SimpleDateFormat;
import com.akshansh.Status;
import com.akshansh.Task;
import com.akshansh.TasksDAO;
import com.google.gson.*;
import picocli.CommandLine;

import java.util.List;
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
            TasksDAO dao = new TasksDAO();
            List<Task> tasks = dao.getTaskList();

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
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
