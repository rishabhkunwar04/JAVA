package org.example.SnakeAndLadder.Model;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private int diceCount;
    private int min = 1;
    private int max = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
       int sum = 0;
       int totCount = 0;

       while(totCount < diceCount) {
           sum = sum + ThreadLocalRandom.current().nextInt(min, max+1);
           totCount++;
       }

       return sum;
    }
}
