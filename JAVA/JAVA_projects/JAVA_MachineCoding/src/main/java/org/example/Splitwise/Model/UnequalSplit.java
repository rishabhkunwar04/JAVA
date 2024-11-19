package org.example.Splitwise.Model;

import java.util.List;

public class UnequalSplit implements ExpenseSplit{
    @Override
    public void validateSplitRequest(List<Split> splitList, double amount) {
        double totalamount = 0;
        for(Split split : splitList) {
           totalamount  = totalamount + split.amount;
        }

        if(totalamount != amount) {
            System.out.println("invalid input ");
            System.exit(0);
        }
    }
}
