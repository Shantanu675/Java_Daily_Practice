package Graphs;

import java.util.PriorityQueue;

class B{
    int row;
    int col;
    int diff;

    B(int row, int col, int diff){
        this.row = row;
        this.col = col;
        this.diff = diff;
    }
}

public class MinEffort {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 2},
                {3, 8, 2},
                {5, 3, 5}};
        System.out.println(MinimumEfforts(grid));
    }

    public static int MinimumEfforts(int[][] height){
        if(height.length == 1 && height[0].length == 1){
            return 0;
        }

        int n = height.length;
        int m = height[0].length;

        int[] src = {0, 0};
        int[] des = {n-1, m-1};

        int[][] efforts = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                efforts[i][j] = (int)1e9;
            }
        }

        PriorityQueue<B> pq = new PriorityQueue<>((x,y) -> x.diff - y.diff);
        pq.offer(new B(src[0], src[1], 0));
        efforts[0][0] = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        while (! pq.isEmpty()){
            B current = pq.poll();
            int row = current.row;
            int col = current.col;
            int diff = current.diff;

            if(row == des[0] && col == des[1]){
                return diff;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + delRow[i];
                int newCol = col + delCol[i];

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m){
                    int calEff = Math.abs(height[newRow][newCol] - height[row][col]);
                    if(calEff < efforts[newRow][newCol]) {
                        efforts[newRow][newCol] = calEff;
                        pq.offer(new B(newRow, newCol, calEff));
                    }
                }
            }
        }
        return -1;
    }
}