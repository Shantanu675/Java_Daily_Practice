package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Pairs{
    int row;
    int col;
    int time;

    Pairs(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}

public class RottenOranges {
    public static void main(String[] args) {
        int[][] matrix = {{1, 1, 2},
                        {1, 1, 0},
                        {0, 0, 1}};

        System.out.println(rottenOranges(matrix));
    }

    private static int rottenOranges(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] copy = new int[n][m];
        for(int i = 0; i < n; i++){
            System.arraycopy(matrix[i], 0, copy[i], 0, m);
        }

        Queue<Pairs> q = new LinkedList<>();
        int time = 0;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 2){
                    q.offer(new Pairs(i, j, time));
                }
            }
        }

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        while(! q.isEmpty()){
            time++;
            int queueSize = q.size();

            for (int i = 0; i < queueSize; i++) {
                Pairs currentNode = q.poll();

                for (int j = 0; j < 4; j++) {
                    int newRow = currentNode.row + delRow[j];
                    int newCol = currentNode.col + delCol[j];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && copy[newRow][newCol] == 1){
                        q.offer(new Pairs(newRow, newCol, time));
                        copy[newRow][newCol] = 2;
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 1 && copy[i][j] != 2){
                    return -1;
                }
            }
        }
        return time-1;
    }
}
