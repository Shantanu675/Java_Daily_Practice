package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class Nodes{
    int row;
    int col;

    Nodes(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Distinctislands {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 0, 0, 1},
                {1, 0, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {1, 1, 0, 1, 1}};

        System.out.println(countDistinctIsland(matrix));
    }

    private static int countDistinctIsland(int[][] matrix) {
        HashSet<List<List<Integer>>> set = new HashSet<>();

        int n = matrix.length;
        int m = matrix[0].length;

        int[][] visit = new int[n][m];

        int[] delrow = {1, 0, -1, 0};
        int[] delcol = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 1 && visit[i][j] == 0){
                    List<List<Integer>> list = new ArrayList<>();
                    list.add(Arrays.asList(0,0));
                    dfs(new Nodes(i, j), list, matrix, visit, delrow, delcol, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private static void dfs(Nodes node, List<List<Integer>> list, int[][] matrix, int[][] visit, int[] delrow, int[] delcol, int baseRow, int baseCol) {
        visit[node.row][node.col] = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = node.row + delrow[i];
            int newCol = node.col + delcol[i];

            if(newRow >= 0 && newRow < matrix.length && newCol >= 0 && newCol < matrix[0].length && visit[newRow][newCol] == 0 && matrix[newRow][newCol] == 1){
                list.add(Arrays.asList(baseRow-newRow, baseCol-newCol));
                dfs(new Nodes(newRow, newCol), list, matrix, visit, delrow, delcol, baseRow, baseCol);
            }
        }
    }
}
