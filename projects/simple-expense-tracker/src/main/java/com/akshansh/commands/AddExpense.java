package com.akshansh.commands;

import com.akshansh.ExpenseDAO;
import com.akshansh.classes.Expense;
import picocli.CommandLine;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "add",
        description = "Add an expense"
)
public class AddExpense implements Callable<Integer> {
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
            List<Expense> expenses = dao.getExpensesList();

            // New expense
            Expense ex = new Expense(dao.getNextId(), cleanDescription, amount, new Date());

            // Adding to list
            expenses.add(ex);

            // Saving the list
            dao.saveExpenseList(expenses);

            System.out.println("Expense added successfully (ID: " + ex.getId() + ")\n");
            return 0;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
