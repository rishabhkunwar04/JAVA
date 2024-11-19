package org.example.Splitwise.Model;


import lombok.Data;

@Data
public class User {
    private String userId;
    private String userName;
    private BalanceSheet balanceSheet;
}
