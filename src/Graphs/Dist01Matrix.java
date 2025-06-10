package Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Info{
    int row;
    int col;

    Info(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class Dist01Matrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 0, 1, 0},
                        {1, 1, 0, 0},
                        {1, 0, 0, 0}};
        System.out.println(Arrays.deepToString(returnDistanceMat(matrix)));
    }

    private static int[][] returnDistanceMat(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] visit = new int[n][m];
        int[][] distance = new int[n][m];

        int[] delrow = {1, 0, -1, 0};
        int[] delcol = {0, 1, 0, -1};

        int dist = 0;
        Queue<Info> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 1){
                    q.offer(new Info(i, j));
                    visit[i][j] = 1;
                    distance[i][j] = dist;
                }
            }
        }

        while(! q.isEmpty()){
            int qSize = q.size();
            dist++;
            for (int i = 0; i < qSize; i++) {
                Info currentNode = q.poll();

                for (int j = 0; j < 4; j++) {
                    int newRow = delrow[j] + currentNode.row;
                    int newCol = delcol[j] + currentNode.col;

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visit[newRow][newCol] == 0){
                        q.offer(new Info(newRow, newCol));
                        visit[newRow][newCol] = 1;
                        distance[newRow][newCol] = dist;
                    }
                }
            }
        }
        return distance;
    }
}