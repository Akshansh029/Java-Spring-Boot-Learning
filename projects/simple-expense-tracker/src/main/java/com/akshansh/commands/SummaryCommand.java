package com.akshansh.commands;

import com.akshansh.ExpenseDAO;
import com.akshansh.classes.Expense;
import picocli.CommandLine;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "summary",
        description = "Summary of all expenses"
)
public class SummaryCommand implements Callable<Integer> {
    @CommandLine.Option(names = {"-m", "--month"})
    private int month;

    @Override
    public Integer call(){
        try{
            if(month < 0 || month > 12){
                System.out.println("Month can only be from 1 to 12, 0 for all expenses");
                return 1;
            }

            ExpenseDAO dao = new ExpenseDAO();
            List<Expense> expenseList = dao.getExpensesList();

            if(month > 0){
                double totalMonthlyExpenses = expenseList.stream()
                        .filter(e -> e.getCreatedAt().getMonth() + 1 == month)
                        .mapToDouble(Expense::getAmount)
                        .reduce(0, Double::sum);

                if(totalMonthlyExpenses != 0){
                    System.out.println("Total Expenses for " + Month.of(month).getDisplayName(TextStyle.FULL, Locale.US) + ": Rs " + totalMonthlyExpenses);
                } else{
                    System.out.println("No expenses for given month!");
                }
            } else{
                double totalExpenses = expenseList.stream()
                        .mapToDouble(Expense::getAmount)
                                                    .reduce(0, Double::sum);

                if(totalExpenses != 0){
                    System.out.println("Total Expenses: Rs " + totalExpenses);
                } else{
                    System.out.println("No expenses yet!");
                }
            }

            return 0;
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return 1;
        }
    }
}
