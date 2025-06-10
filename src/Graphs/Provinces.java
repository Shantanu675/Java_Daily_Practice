package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Graphs.MatrixToList.createList;

public class Provinces {
    public static void main(String[] args) {
//        int[][] matrix = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 1, 0, 0, 0, 0, 0, 0},
//                        {0, 1, 0, 1, 0, 0, 0, 0, 0},
//                        {0, 0, 1, 0, 0, 0, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 1, 0, 0, 0},
//                        {0, 0, 0, 0, 1, 0, 1, 0, 0},
//                        {0, 0, 0, 0, 0, 1, 0, 0, 0},
//                        {0, 0, 0, 0, 0, 0, 0, 0, 1},
//                        {0, 0, 0, 0, 0, 0, 0, 1, 0}};
        int[][] matrix = {{1,1,0},{1,1,0},{0,0,1}};

        System.out.println(countProvinces(matrix));
    }

    private static int countProvinces(int[][] matrix) {
        List<List<Integer>> graph = createList(matrix);
        int[] visit = new int[graph.size()];
        int count = 0;

        for(int i = 0; i < graph.size()-1; i++){
            if (visit[i+1] == 0) {
                count++;
                dfs(graph, i+1, visit);
            }
        }
        return count;
    }

    public static List<List<Integer>> createList(int[][] isConnected) {
        List<List<Integer>> graph = new ArrayList<>();

        int n = isConnected.length;

        for(int i = 0; i < n; i++){
            List<Integer> links = new ArrayList<>();
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                if(isConnected[i][j] == 1){
                    links.add(j);
                }
            }
            graph.add(links);
        }
        return graph;
    }

    private static void dfs(List<List<Integer>> graph, int node, int[] visit) {
        visit[node] = 1;
        //list.add(node);

        for(int val : graph.get(node)){
            if(visit[val] == 0){
                dfs(graph, val, visit);
            }
        }
    }
}