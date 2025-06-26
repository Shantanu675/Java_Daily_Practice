package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class A{
    int row;
    int col;
    int dist;

    A(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}

public class ShortestDistGrid {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1, 1},
                        {1, 1, 0, 1},
                        {1, 1, 1, 1},
                        {1, 1, 0, 0},
                        {1, 0, 0, 1}};
        int[] src = {0, 1};
        int[] des = {2, 2};
        System.out.println(shortest(grid, src, des));
    }

    private static int shortest(int[][] grid, int[] src, int[] des) {
        if(src[0] == des[0] && src[1] == des[1]){
            return 0;
        }

        int n = grid.length;
        int m = grid[0].length;
        int[][] d = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                d[i][j] = (int)1e9;
            }
        }

        Queue<A> q = new LinkedList<>();
        q.offer(new A(src[0], src[1], 0));

        // for traversing all four sides of cells
        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, 1, 0, -1};

        while (! q.isEmpty()){
            A current = q.poll();
            int row = current.row;
            int col = current.col;
            int dist = current.dist;

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1 && d[newRow][newCol] > dist + 1){
                    if(newRow == des[0] && newCol == des[1]){
                        return dist + 1;
                    }
                    d[newRow][newCol] = dist + 1;
                    q.offer(new A(newRow, newCol, dist + 1));
                }
            }
        }
        return -1;
    }
}