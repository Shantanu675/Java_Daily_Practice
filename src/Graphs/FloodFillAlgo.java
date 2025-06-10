package Graphs;

import java.util.Arrays;

public class FloodFillAlgo {
    public static void main(String[] args) {
        int[][] image = {{0, 0, 0},
                        {0, 0, 0}};

        int[][] ans = floodFill(image, 0, 0, 0);
        System.out.println(Arrays.deepToString(ans));
    }

    private static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int coloumns = image[0].length;

        int initialColor = image[sr][sc];
        int[][] copy = new int[rows][coloumns];
        int[][] visit = new int[rows][coloumns];

        for(int i = 0; i < rows; i++){
            for (int j = 0; j < coloumns; j++) {
                copy[i][j] = image[i][j];
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        dfs(sr, sc , copy, newColor, initialColor, delRow, delCol, visit);
        return copy;
    }

    private static void dfs(int sr, int sc, int[][] copy, int newColor, int initialColor, int[] delRow, int[] delCol, int[][] visit){
        copy[sr][sc] = newColor;
        visit[sr][sc] = 1;
        int n = copy.length;
        int m = copy[0].length;

        for(int i = 0; i < 4; i++){
            int newRow = delRow[i] + sr;
            int newCol = delCol[i] + sc;

            if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && copy[newRow][newCol] == initialColor && visit[newRow][newCol] == 0) {
                dfs(newRow, newCol, copy, newColor, initialColor, delRow, delCol, visit);
            }
        }
    }
}
