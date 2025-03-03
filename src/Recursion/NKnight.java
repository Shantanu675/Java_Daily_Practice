package Recursion;

public class NKnight {
    public static void main(String[] args) {
        boolean[][] board = new boolean[2][2];
        placeKnight(board, 0, 0 , 4);
    }

    public static void placeKnight(boolean[][] board, int row, int col, int knight){
        if(knight == 0){
            displayBoard(board);
            System.out.println();
            return;
        }

        if(row == board.length-1 && col == board.length){
            return;
        }

        if(col == board.length){
            placeKnight(board, row+1, 0, knight);
        }

        if(isSafe(board, row, col)){
            board[row][col] = true;
            placeKnight(board, row, col+1, knight-1);
            board[row][col] = false;
        }
        placeKnight(board, row, col+1, knight);
    }

    public static boolean isSafe(boolean[][] board, int row, int col){
        // Check if the position (row-2, col-1) is valid and occupied by a knight
        if(isValid(board, row-2, col-1)){
            if(board[row-2][col-1]){
                return false;
            }
        }

        // Check if the position (row-1, col-2) is valid and occupied by a knight
        if(isValid(board, row-1, col-2)){
            if(board[row-1][col-2]){
                return false;
            }
        }

        // Check if the position (row-2, col+1) is valid and occupied by a knight
        if(isValid(board, row-2, col+1)){
            if(board[row-2][col+1]){
                return false;
            }
        }

        // Check if the position (row-1, col+2) is valid and occupied by a knight
        if(isValid(board, row-1, col+2)){
            if(board[row-1][col+2]){
                return false;
            }
        }

        // Check if the position (row+1, col-2) is valid and occupied by a knight
        if(isValid(board, row+1, col-2)){
            if(board[row+1][col-2]){
                return false;
            }
        }

        // Check if the position (row+2, col-1) is valid and occupied by a knight
        if(isValid(board, row+2, col-1)){
            if(board[row+2][col-1]){
                return false;
            }
        }

        // Check if the position (row+1, col+2) is valid and occupied by a knight
        if(isValid(board, row+1, col+2)){
            if(board[row+1][col+2]){
                return false;
            }
        }

        // Check if the position (row+2, col+1) is valid and occupied by a knight
        if(isValid(board, row+2, col+1)){
            if(board[row+2][col+1]){
                return false;
            }
        }

        // If all the checks passed, return true (the knight can be placed)
        return true;
    }

    public static boolean isValid(boolean[][] board, int row, int col){
        if(row >= 0 && row < board.length && col >= 0 && col < board.length){
            return true;
        }
        return false;
    }

    public static void displayBoard(boolean[][] board){
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col]){
                    System.out.print("K ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
