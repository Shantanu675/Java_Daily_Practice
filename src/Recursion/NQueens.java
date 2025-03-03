package Recursion;

public class NQueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        placeQueen(board,0);
    }

    public static int placeQueen(boolean[][] board,int row){
        if(row == board.length){
            displayBoard(board);
            System.out.println();
            return 1;
        }

        int count = 0;
        for(int col=0; col < board.length; col++){
            if(isSafe(board, row, col)){
                board[row][col] = true;
                placeQueen(board, row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    public static boolean isSafe(boolean[][] board, int row, int col){
        for(int i = 0; i < row; i++){
            if(board[i][col]){
                return false;
            }
        }

        int leftMax = Math.min(row, col);
        for(int i = 1; i <= leftMax; i++){
            if(board[row-i][col-i]){
                return false;
            }
        }

        int rightMax = Math.min(row, board.length-col-1);
        for(int i = 1; i <= rightMax; i++){
            if(board[row-i][col+i]){
                return false;
            }
        }

        return true;
    }

    public static void displayBoard(boolean[][] board){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col]){
                    System.out.print("Q ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
