package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class KosarajuAlgo {
    public static void main(String[] args) {
        int n = 8;

        List<List<Integer>> adj = new ArrayList<>();

        adj.add(Arrays.asList(1));
        adj.add(Arrays.asList(2));
        adj.add(Arrays.asList(0,3));
        adj.add(Arrays.asList(4));
        adj.add(Arrays.asList(5,7));
        adj.add(Arrays.asList(6));
        adj.add(Arrays.asList(4,7));
        adj.add(Arrays.asList());

        System.out.println(kosaraju(n, adj));
    }

    public static int kosaraju(int v, List<List<Integer>> adj){
        int[] visit = new int[v];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < v; i++) {
            if(visit[i] == 0){
                dfs(i, visit, adj, st);
            }
        }

        List<List<Integer>> adjList = new ArrayList<>();
        Arrays.fill(visit, 0);
        for (int i = 0; i < v; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < v; i++) {
            for (int it : adj.get(i)){
                adjList.get(it).add(i);
            }
        }

        int count = 0;
        while (! st.isEmpty()){
            int node = st.pop();
            if(visit[node] == 0){
                count++;
                dfs(node, visit, adjList);
            }
        }
        return count;
    }

    private static void dfs(int node, int[] visit, List<List<Integer>> adj, Stack<Integer> st){
        visit[node] = 1;
        for (int it : adj.get(node)){
            if(visit[it] == 0){
                dfs(it, visit, adj, st);
            }
        }
        st.push(node);
    }

    private static void dfs(int node, int[] visit, List<List<Integer>> adj){
        visit[node] = 1;
        for (int it : adj.get(node)){
            if(visit[it] == 0){
                dfs(it, visit, adj);
            }
        }
    }
}
