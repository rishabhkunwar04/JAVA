package Design_questions.ticTacToe;

public class Player {
    private String Name;
    private char symbol;
    public Player(String name, char symbol){
        Name = name;
        this.symbol = symbol;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}