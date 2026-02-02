package com.akshansh.commands;

import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "list",
        description = "List all expenses"
)
public class ListExpenses implements Callable<Integer> {
    @Override
    public Integer call(){

    }
}
