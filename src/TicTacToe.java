import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        int moves = 9;
        char[][] grid = new char[3][3];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j] = ' ';
            }
        }

        char currPlayer = 'O';
        boolean gameOver = false;

        while(!gameOver){
            printGrid(grid);
            System.out.print("Enter " + currPlayer + " (row , col) : ");
            Scanner scanner = new Scanner(System.in);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if(row > 2 || col > 2 || grid[row][col] != ' '){
                System.out.println("Invalid move");
            }
            else {
                grid[row][col] = currPlayer;
                moves--;

                if(hasWon(grid, currPlayer)){
                    printGrid(grid);
                    System.out.println("Winner is " + currPlayer);
                    gameOver = true;
                    return;
                }

                if(moves < 1){
                    printGrid(grid);
                    System.out.println("Tie");
                    gameOver = true;
                    return;
                }

                if(currPlayer == 'O'){
                    currPlayer = 'X';
                }
                else{
                    currPlayer = 'O';
                }
            }
        }
    }

    private static boolean hasWon(char[][] grid, char currPlayer) {
        //row wise
        for(int row = 0; row < grid.length; row++){
            if(grid[row][0] == currPlayer && grid[row][1] == currPlayer && grid[row][2] == currPlayer){
                return true;
            }
        }

        //col wise
        for(int col = 0; col < grid.length; col++){
            if(grid[0][col] == currPlayer && grid[1][col] == currPlayer && grid[2][col] == currPlayer){
                return true;
            }
        }

        //diagonal1
        if(grid[0][0] == currPlayer && grid[1][1] == currPlayer && grid[2][2] == currPlayer){
            return true;
        }

        //diagonal2
        if(grid[2][0] == currPlayer && grid[1][1] == currPlayer && grid[0][2] == currPlayer){
            return true;
        }
        return false;
    }

    private static void printGrid(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j] + " | ");
            }
            System.out.println();
        }
    }
}
