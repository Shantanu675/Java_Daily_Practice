package Graphs;

import java.util.Arrays;

public class ReplaceOX {
    public static void main(String[] args) {
        char[][] matrix = {{'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};

        System.out.println(Arrays.deepToString(replaceOX(matrix)));
    }

    private static char[][] replaceOX(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] visit = new int[n][m];

        int[] delrow = {1, 0 , -1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(matrix[i][j] == 'O'){
                        dfs(i, j, matrix, visit, delrow, delcol);
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 'O' && visit[i][j] == 1){
                    matrix[i][j] = 'O';
                }
                else {
                    matrix[i][j] = 'X';
                }
            }
        }
        return matrix;
    }

    private static void dfs(int row, int col, char[][] matrix, int[][] visit, int[] delrow, int[] delcol){
        visit[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int newRow = row + delrow[i];
            int newCol = col + delcol[i];

            if(newRow >= 0 && newRow < visit.length && newCol >= 0 && newCol < visit[0].length && visit[newRow][newCol] == 0 && matrix[newRow][newCol] == 'O'){
                dfs(newRow, newCol, matrix, visit, delrow, delcol);
                visit[newRow][newCol] = 1;
            }
        }
    }
}
