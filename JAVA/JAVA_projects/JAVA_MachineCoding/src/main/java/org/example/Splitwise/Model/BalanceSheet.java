package org.example.Splitwise.Model;

import lombok.Data;

import java.util.Map;

@Data
public class BalanceSheet {
    private Map<User, Balance> userVsBalance;
    private double totalYourExpense;
    private double totalYouOwe;
    private double totalGetBack;
    private double totalPayment;
}
