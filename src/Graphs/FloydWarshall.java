package Graphs;

import java.util.Arrays;

public class FloydWarshall {
    public static void main(String[] args) {
        //int[][] graph = {{0,1,43}, {1,0,6}, {-1,-1,0}};
        int[][] graph ={{0,-2,-1}, {-1,0,-3}, {2,-1,0}};
        System.out.println(Arrays.deepToString(floydWarshall(graph)));
    }

    private static int[][] floydWarshall(int[][] graph) {
        int n = graph.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(graph[i][j] == -1){
                    graph[i][j] = (int)1e9;
                }
                if(i == j){
                    graph[i][j] = 0;
                }
            }
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][via] + graph[via][j]);
                }
            }
        }

        //check whether negative cycle exist or not
        for (int i = 0; i < n; i++) {
            if(graph[i][i] < 0){
                int[][] temp = {{-1}};
                return temp;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1e9){
                    graph[i][j] = -1;
                }
            }
        }
        return graph;
    }
}
