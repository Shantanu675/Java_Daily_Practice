package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int row;
    int col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Island {
    public static void main(String[] args) {
        int[][] grid = {{0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 1, 0},
                        {0, 0, 0, 0},
                        {1, 1, 0, 1}};

        System.out.println(countIsland(grid));
    }

    private static int countIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] copy = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                copy[i][j] = grid[i][j];
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(copy[i][j] == 1){
                    bfs(i, j, copy);
                    count++;
                }
            }
        }
        return count;
    }

    private static void bfs(int i, int j, int[][] copy) {
        int n = copy.length;
        int m = copy[0].length;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j));
        copy[i][j] = 0;

        while(! q.isEmpty()){
            int qSize = q.size();
            Pair currentNode = null;
            for(int k = 0; k < qSize; k++) {
                currentNode = q.poll();

                if (currentNode == null) {
                    return;
                }

                for (int delrow = -1; delrow < 2; delrow++) {
                    for (int delcol = -1; delcol < 2; delcol++) {
                        int newRow = currentNode.row + delrow;
                        int newCol = currentNode.col + delcol;

                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && copy[newRow][newCol] == 1) {
                            q.offer(new Pair(newRow, newCol));
                            copy[newRow][newCol] = 0;
                        }
                    }
                }
            }
        }
    }
}
