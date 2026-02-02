package com.akshansh.commands;

import com.akshansh.ExpenseDAO;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "delete",
        description = "Delete an expense"
)
public class DeleteExpense implements Callable<Integer> {
    @CommandLine.Option(names = {"-i", "--id"}, required = true)
    private int id;

    @Override
    public Integer call(){
        try{
            ExpenseDAO dao = new ExpenseDAO();

            if(dao.removeExpense(id)){
                System.out.println("Expense delete successfully");
            } else{
                System.out.println("Expense with ID: " + id + " not found");
            }
            return 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
