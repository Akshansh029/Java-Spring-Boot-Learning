package com.akshansh.commands;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import picocli.CommandLine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@CommandLine.Command(
        name = "add",
        description = "add task"
)
public class TaskCLIAdd implements Runnable{
    @CommandLine.Option(names = {"add"}, required = true)
    private String task;

    @Override
    public void run() {
        // Read existing JSON
        JsonObject jsonObject = null;
        try {
            jsonObject = JsonParser.parseReader(new FileReader("data.json")).getAsJsonObject();

            jsonObject.addProperty("cliInput", task);

            // Write back to file
            try (FileWriter fileWriter = new FileWriter("data.json")) {
                    fileWriter.write(jsonObject.toString());
            }
        } catch (IOException e ) {
            throw new RuntimeException(e);
        }
        System.out.println("Task added successfully ");
    }

}
