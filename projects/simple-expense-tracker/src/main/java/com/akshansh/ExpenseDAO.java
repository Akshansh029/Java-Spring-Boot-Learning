package com.akshansh;

import com.akshansh.classes.Expense;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final File file = new File("data.json");

    public List<Expense> getExpensesList() {
        try {
            if (file.exists()) {
                try (FileReader fr = new FileReader(file)) {
                    JsonElement jsonElement = JsonParser.parseReader(fr);
                    if (jsonElement.isJsonObject()) {
                        JsonObject root = jsonElement.getAsJsonObject();
                        if (root.has("expenses")) {
                            Type taskListType = new TypeToken<List<Expense>>(){}.getType();
                            return gson.fromJson(root.get("expenses"), taskListType);
                        }
                    }
                }
            }
            return new ArrayList<>();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveExpenseList(List<Expense> expenses) throws IOException {
        JsonObject root = new JsonObject();
        root.add("expenses", gson.toJsonTree(expenses));

        try (FileWriter fileWriter = new FileWriter(file)) {
            gson.toJson(root, fileWriter);
        }
    }

    public int getNextId() {
        List<Expense> expenses = getExpensesList();
        if (expenses.isEmpty()) {
            return 1;
        }

        // Find the maximum ID
        int maxId = expenses.stream()
                .mapToInt(Expense::getId)
                .max()
                .orElse(0);

        return maxId + 1;
    }
}
