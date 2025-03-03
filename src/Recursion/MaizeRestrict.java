package Recursion;

public class MaizeRestrict {
    public static void main(String[] args) {
        boolean[][] board = {{true,true,true}, {true,false,true}, {true,true,true}};
        System.out.println(countPath(board,0,0));
        printPaths("",board,0,0);
    }

    //think for if first cell is blocked

    public static int countPath(boolean[][] maze, int row, int col){
        if(row == maze.length-1 || col == maze[0].length-1){
            return 1;
        }

        if(!maze[row][col]){
            return 0;
        }

        int down = countPath(maze,row+1,col);
        int right = countPath(maze,row,col+1);

        return right+down;
    }

    public static void printPaths(String p, boolean[][] maze, int row, int col){

        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            return;
        }

        if(!maze[row][col]){
            return;
        }

        if(row < maze.length-1){
            printPaths(p+"D",maze,row+1,col);
        }
        if(col < maze[0].length-1){
            printPaths(p+"R",maze,row,col+1);
        }
    }
}
