package Recursion;

public class Maze {

    public static void main(String[] args) {
        System.out.println(countPath(3,3));
        printPaths("",3,3);
        System.out.println(countPathsWithDiag(3,3));
        printWithDiag("",3,3);
    }

    public static int countPath(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }

        int down = countPath(row-1, col);
        int right = countPath(row, col-1);
        return down + right;
    }

    public static void printPaths(String p ,int row, int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row > 1) {
            printPaths(p + "D", row - 1, col);
        }
        if(col > 1) {
            printPaths(p + "R", row, col - 1);
        }
    }

    public static int countPathsWithDiag(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }

        int down = countPathsWithDiag(row-1,col);
        int diag = countPathsWithDiag(row-1,col-1);
        int right = countPathsWithDiag(row,col-1);

        return down+diag+right;
    }

    public static void printWithDiag(String p, int row,int col){
        if(row == 1 && col == 1){
            System.out.println(p);
            return;
        }

        if(row > 1 && col > 1){
            printWithDiag(p+"D",row-1,col-1);
        }
        if(row > 1){
            printWithDiag(p+"V",row-1,col);
        }
        if(col > 1){
            printWithDiag(p+"H",row,col-1);
        }
    }
}