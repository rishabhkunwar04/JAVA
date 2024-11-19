package org.example.Splitwise.Model;

import java.util.List;

public class EqualSplit implements ExpenseSplit{
    @Override
    public void validateSplitRequest(List<Split> splitList, double amount) {
        double splitamount = amount / splitList.size();
        for(Split split : splitList) {
            if(split.amount != splitamount) {
                System.out.println("invalid input ");
                System.exit(0);
            }
        }
    }
}
