package com.akshansh.classes;

public enum ExpenseCategories {
    HOUSING("Housing"), UTILITIES("Utilities"), TRANSPORTATION("Transportation"),
    GROCERIES_FOOD("Groceries&Food"), PERSONAL("Personal&Discretionary"),
    DEBT("debt"), SAVINGS_INVESTMENTS("Savings&Investments");

    private final String category;

    ExpenseCategories(String category){
        this.category = category;
    }

    public String getCategory() {
        return category;
    }
}
