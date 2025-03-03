package Recursion;
import java.util.Arrays;

public class MazeBacktrack {
    static int count;
    public static void main(String[] args) {
        boolean[][] board = {{true,true,true},{true,true,true},{true,true,true}};
        //System.out.println(countPaths(board,0,0));
        //printPaths("",board,0,0);
        //System.out.println(count);

        int[][] path = new int[board.length][board[0].length];
        allPrint("",board,0,0,path,1);
    }

    public static void printPaths(String p, boolean[][] maze,int row,int col){
        if(row == maze.length-1 && col == maze[0].length-1){
            System.out.println(p);
            count++;
            return;
        }

        if(!maze[row][col]){
            return;
        }

        maze[row][col] = false;

        if(row < maze.length-1){
            printPaths(p+'D',maze,row+1,col);
        }

        if(col < maze[0].length-1){
            printPaths(p+'R',maze,row,col+1);
        }

        if(row > 0){
            printPaths(p+'U',maze,row-1,col);
        }

        if(col > 0){
            printPaths(p+'L',maze,row,col-1);
        }

        maze[row][col] = true;
    }

    public static void allPrint(String p, boolean[][] maze, int row, int col, int[][] path, int step){
        if(row == maze.length-1 && col == maze[0].length-1){
            path[row][col] = step;
            for(int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(p);
            System.out.println();
            return;
        }

        if(!maze[row][col]){
            return;
        }

        maze[row][col] = false;
        path[row][col] = step;

        if(row < maze.length-1){
            allPrint(p+'D',maze,row+1,col,path,step+1);
        }

        if(col < maze[0].length-1){
            allPrint(p+'R',maze,row,col+1,path,step+1);
        }

        if(row > 0){
            allPrint(p+'U',maze,row-1,col,path,step+1);
        }

        if(col > 0){
            allPrint(p+'L',maze,row,col-1,path,step+1);
        }

        maze[row][col] = true;
        path[row][col] = 0;
    }
}
