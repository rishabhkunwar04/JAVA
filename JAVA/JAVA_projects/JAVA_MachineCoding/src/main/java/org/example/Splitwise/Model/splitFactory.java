package org.example.Splitwise.Model;

public class splitFactory {
    public static ExpenseSplit getSplitObject(SplitType splitType) {
        switch (splitType) {
            case PERC:{
                return new PercSplit();
            }
            case EQUAL:{
                return new EqualSplit();
            }
            case UNEQUAL:{
                return new UnequalSplit();
            }
        }

        return null;
    }
}
