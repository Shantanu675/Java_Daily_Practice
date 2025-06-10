package Graphs;

import java.util.Arrays;

public class MatrixRepresentation {
    public static void main(String[] args) {
        int n = 3, m = 3;
        int[][] adj = new int[n+1][m+1];

        //1->2
        adj[1][2] = 1;
        adj[2][1] = 1;

        //2->3
        adj[2][3] = 1;
        adj[3][2] = 1;

        //1->3
        adj[1][3] = 1;
        adj[3][1] = 1;

        // or using loop

        System.out.println(Arrays.deepToString(adj));
    }
}
