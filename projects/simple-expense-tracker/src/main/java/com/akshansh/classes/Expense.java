package com.akshansh.classes;

import java.util.Date;

public class Expense {
    private int id;
    private String description;
    private double amount;
    private Date createdAt;

    public Expense(int id, String description, double amount, Date createdAt) {
        if(id <= 0){
            throw new IllegalArgumentException("Expense ID cannot must be a natural number");
        } else if (description.isEmpty()) {
            throw new IllegalArgumentException("Expense must have a description");
        } else if (amount <= 0) {
            throw new IllegalArgumentException("Expense amount cannot be less than Rs.1");
        } else if (createdAt == null) {
            throw new IllegalArgumentException("Expense must have a date");
        }
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.createdAt = createdAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", createdAt=" + createdAt +
                '}';
    }
}
