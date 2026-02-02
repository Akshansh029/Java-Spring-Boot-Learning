package com.akshansh.commands;

import com.akshansh.ExpenseDAO;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "update",
        description = "Update and expense"
)
public class UpdateExpense implements Callable<Integer> {
    @CommandLine.Option(names = {"-i", "--id"}, required = true)
    private int id;

    @CommandLine.Option(names = {"-d", "--description"}, required = true)
    private String description;

    @CommandLine.Option(names = {"-a", "--amount"}, required = true)
    private double amount;

    @Override
    public Integer call(){
        String cleanDescription = description;
        if (cleanDescription.startsWith("\"") && cleanDescription.endsWith("\"")) {
            cleanDescription = cleanDescription.substring(1, cleanDescription.length() - 1);
        }

        try{
            ExpenseDAO dao = new ExpenseDAO();

            if(dao.updateExpense(id, cleanDescription, amount)){
                System.out.println("Expense updated successfully (ID: " + id + ")");
            } else{
                System.out.println("Expense with ID: " + id + " not found");
            }
            return 0;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
