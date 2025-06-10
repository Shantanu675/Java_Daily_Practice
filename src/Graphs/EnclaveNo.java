package Graphs;

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int row;
    int col;

    Node(int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class EnclaveNo {
    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 1, 1},
                        {0, 1, 1, 0},
                        {0, 1, 1, 0},
                        {0, 0, 0, 1},
                        {0, 1, 1, 0}};

        System.out.println(countEnclave(matrix));
    }

    private static int countEnclave(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] visit = new int[n][m];

        int[] delrow = {1, 0, -1, 0};
        int[] delcol = {0, 1, 0, -1};

        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 || i == n-1 || j == 0 || j == m-1) {
                    if (matrix[i][j] == 1) {
                        q.add(new Node(i, j));
                        visit[i][j] = 1;
                    }
                }
            }
        }

        while (! q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node currentNode = q.poll();

                for (int j = 0; j < 4; j++) {
                    int newRow = currentNode.row + delrow[j];
                    int newCol = currentNode.col + delcol[j];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visit[newRow][newCol] == 0 && matrix[newRow][newCol] == 1){
                        q.offer(new Node(newRow, newCol));
                        visit[newRow][newCol] = 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j] == 1 && visit[i][j] == 0){
                    count++;
                }
            }
        }
        return count;
    }
}
