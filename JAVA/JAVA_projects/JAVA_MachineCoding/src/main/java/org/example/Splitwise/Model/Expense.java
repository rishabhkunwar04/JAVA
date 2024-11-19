package org.example.Splitwise.Model;

import java.util.List;

public class Expense {
    private String expenseId;
    private String description;
    private User paidByUser;
    private Double amount;
    private SplitType splitType;
    private List<Split> splitList;

    public Expense(String expenseId, String description, User paidByUser, Double amount, SplitType splitType, List<Split> splitList) {
        this.expenseId = expenseId;
        this.description = description;
        this.paidByUser = paidByUser;
        this.amount = amount;
        this.splitType = splitType;
        this.splitList = splitList;
    }
}
