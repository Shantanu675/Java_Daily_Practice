package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.SequencedCollection;

public class MatrixToList {
    public static void main(String[] args) {
        int[][] arr = {{1,0,0,0},{0,1,1,0},{0,1,1,0},{0,0,0,1}};
        System.out.println(createList(arr));
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
}
