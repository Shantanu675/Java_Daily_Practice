package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Graphs.MatrixToList.createList;

public class DFS {
    public static void main(String[] args) {
        int[][] graph = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 1, 1, 0, 0},
                        {0, 1, 0, 0, 1, 0, 0, 1, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 1, 0, 0, 1, 0}};

        List<List<Integer>> g = createList(graph);
        System.out.println(Arrays.toString(g.toArray()));

        List<Integer> ans = dfs(g, 1);
        System.out.println(Arrays.toString(ans.toArray()));
    }


    private static List<Integer> dfs(List<List<Integer>> g, int i) {
        List<Integer> list = new ArrayList<>();
        int[] visit = new int[g.size()];
        traversal(g, i, list, visit);
        return list;
    }

    private static void traversal(List<List<Integer>> graph, int node, List<Integer> list, int[] visit) {
        visit[node] = 1;
        list.add(node);

        for(int val : graph.get(node)){
            if(visit[val] == 0){
                traversal(graph, val, list, visit);
            }
        }
    }
}
