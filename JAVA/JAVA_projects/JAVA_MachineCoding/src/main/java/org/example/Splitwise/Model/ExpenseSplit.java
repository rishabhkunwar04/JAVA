package org.example.Splitwise.Model;

import java.util.List;

public interface ExpenseSplit {
    public void validateSplitRequest(List<Split> splitList, double amount);
}
