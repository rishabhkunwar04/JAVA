package Design_questions.ticTacToe;


public class Board {

    private char [][]grid;
    private int movesCount;
    public Board(){
        grid=new char[3][3];
        movesCount=0;
        //initialize grid
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                grid[i][j]='-';
            }
        }
    }
    public synchronized void makeMove(int i, int j, char symbol){
        if(i<0 || i>2 || j<0 || j>2 || grid[i][j]!='-') {
            // indexout of BoundMove
            throw new IllegalArgumentException("Invalid Move !!");
        }
        grid[i][j]=symbol;
        movesCount++;

    }

    public boolean hasWinner() {
        // Check rows
        for (int row = 0; row < 3; row++) {
            if (grid[row][0] != '-' && grid[row][0] == grid[row][1] && grid[row][1] == grid[row][2]) {
                return true;
            }
        }

        // Check columns
        for (int col = 0; col < 3; col++) {
            if (grid[0][col] != '-' && grid[0][col] == grid[1][col] && grid[1][col] == grid[2][col]) {
                return true;
            }
        }

        // Check diagonals
        if (grid[0][0] != '-' && grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]) {
            return true;
        }
        return grid[0][2] != '-' && grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0];
    }

    public void printBoard() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(grid[row][col] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    public  boolean isFull(){
        if(movesCount==9){
            return true;
        }
        return false;
    }

}