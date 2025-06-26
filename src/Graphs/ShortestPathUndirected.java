package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class I{
    int node;
    int dist;

    I(int node, int dist){
        this.node = node;
        this.dist = dist;
    }
}

public class ShortestPathUndirected {
    public static void main(String[] args) {
        int nodes = 9;
        int e = 10;
        int[][] edges = {{0,1},{0,3},{3,4},{4,5},{5,6},{1,2},{2,6},{6,7},{7,8},{6,8}};
        System.out.println(Arrays.toString(shortestPath(nodes, e, edges, 0)));
    }

    public static int[] shortestPath(int n, int m, int[][] edges, int src){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)1e9;
        }
        dist[src] = 0;

        Queue<I> q = new LinkedList<>();
        q.offer(new I(src, 0));

        while(! q.isEmpty()){
            I current = q.poll();
            for(int it : adj.get(current.node)){
                int calDist = current.dist + 1;
                if(dist[it] > calDist){
                    dist[it] = calDist;
                    q.offer(new I(it, dist[it]));
                }
            }
        }
        return dist;
    }
}
