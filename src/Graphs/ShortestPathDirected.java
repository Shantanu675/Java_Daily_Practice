package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Inf{
    int node;
    int dist;

    Inf(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}
public class ShortestPathDirected {
    public static void main(String[] args) {
        //int[][] graph = {{0,1,2}, {0,4,1}, {4,5,4}, {4,2,2}, {1,2,3}, {2,3,6}, {5,3,1}};
        int[][] graph = {{0,1,2}, {1,3,1}, {2,3,3}, {4,0,3}, {4,2,1}, {6,4,2}, {6,5,3}, {5,4,1}};
        int nodes = 7;
        int edges = graph.length;
        System.out.println(Arrays.toString(shortestPath(nodes, edges, graph)));
    }

    private static int[] shortestPath(int n, int m, int[][] edges) {
        ArrayList<ArrayList<Inf>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ArrayList<Inf> temp = new ArrayList<>();
            adj.add(temp);
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Inf(v,wt));
        }

        int[] visit = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(visit[i] == 0){
                topoSort(i, adj, visit, st);
            }
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)1e9;
        }

        dist[6] = 0;

        while(! st.empty()){
            int current = st.pop();
            for (Inf it : adj.get(current)){
                int calDist = dist[current] + it.dist;
                if(calDist < dist[it.node]){
                    dist[it.node] = calDist;
                }
            }
        }
        return dist;
    }

    private static void topoSort(int node, ArrayList<ArrayList<Inf>> adj, int[] visit, Stack<Integer> st) {
        visit[node]  = 1;
        for (Inf it : adj.get(node)){
            if(visit[it.node] == 0){
                topoSort(it.node, adj, visit, st);
            }
        }
        st.push(node);
    }
}
