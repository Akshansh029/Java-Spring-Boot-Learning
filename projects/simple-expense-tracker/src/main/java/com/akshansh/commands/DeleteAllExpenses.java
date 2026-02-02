package com.akshansh.commands;

import com.akshansh.ExpenseDAO;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "delete-all",
        description = "Delete all expenses"
)
public class DeleteAllExpenses implements Callable<Integer> {
    @Override
    public Integer call(){
        try{
            ExpenseDAO dao = new ExpenseDAO();

            dao.saveExpenseList(new ArrayList<>());

            System.out.println("All expenses removed successfully");
            return 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
