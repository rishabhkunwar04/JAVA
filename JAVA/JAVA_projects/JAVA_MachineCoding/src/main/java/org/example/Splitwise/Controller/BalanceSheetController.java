package org.example.Splitwise.Controller;

import org.example.Splitwise.Model.BalanceSheet;
import org.example.Splitwise.Model.Split;
import org.example.Splitwise.Model.SplitType;
import org.example.Splitwise.Model.User;

import java.util.List;

public class BalanceSheetController {

    public void update(User user, List<Split> splitList, double totalAmount) {
        BalanceSheet balanceSheet = user.getBalanceSheet();
        balanceSheet.setTotalPayment(user.getBalanceSheet().getTotalPayment()  + totalAmount);

        for(Split split : splitList ) {

        }
    }
}
