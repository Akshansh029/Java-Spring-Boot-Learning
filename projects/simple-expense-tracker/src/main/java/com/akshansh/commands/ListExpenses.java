package com.akshansh.commands;

import com.akshansh.ExpenseDAO;
import com.akshansh.classes.Expense;
import picocli.CommandLine;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "list",
        description = "List all expenses"
)
public class ListExpenses implements Callable<Integer> {
    @Override
    public Integer call(){
        try{
            ExpenseDAO dao = new ExpenseDAO();
            List<Expense> expenseList = dao.getExpensesList();

            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");

            if(expenseList.isEmpty()){
                System.out.println("No expenses yet!");
            } else{
                System.out.printf(
                        "%-8s %-15s %-30s %-20s%n",
                        "ID",
                        "Date",
                        "Description",
                        "Amount"
                );
                for (Expense expense : expenseList) {
                    System.out.printf(
                            "%-8s %-15s %-30s %-20s%n",
                            expense.getId(),
                            formatter.format(expense.getCreatedAt()),
                            expense.getDescription(),
                            expense.getAmount()
                    );
                }
            }

            return 0;
        } catch (Exception e){
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
