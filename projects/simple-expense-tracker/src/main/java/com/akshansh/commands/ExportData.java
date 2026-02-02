package com.akshansh.commands;

import com.akshansh.ExpenseDAO;
import com.akshansh.classes.Expense;
import picocli.CommandLine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

@CommandLine.Command(
        name = "export",
        description = "Export expenses data into csv"
)
public class ExportData implements Callable<Integer> {
    @CommandLine.Option(names = {"-n", "--name"}, required = true)
    private String fileName;

    @Override
    public Integer call(){
        try (FileWriter writer = new FileWriter(fileName + ".csv")) {
            ExpenseDAO dao = new ExpenseDAO();
            List<Expense> expenseList = dao.getExpensesList();

            writer.write("id,date,description,amount\n");

            for (Expense expense : expenseList) {
                writer.write(
                        expense.getId() + "," +
                                expense.getCreatedAt() + "," +
                                expense.getDescription() + "," +
                                expense.getAmount() + "\n"
                );
            }

            System.out.println("File '" + fileName + ".csv' created or updated successfully.");
            return 0;
        } catch (IOException e) {
            System.out.println("An error occurred while exporting expenses to CSV.");
            return 1;
        }
    }
}
