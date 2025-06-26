package Graphs;

import java.util.ArrayList;
import java.util.List;

class DiSet {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DiSet(int n){
        for (int i = 0; i < n+1; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    public int findParent(int n){
        while(parent.get(n) != n){
            n = parent.get(n);
        }
        return parent.get(n);
    }

    public void unionByRank(int u, int v){
        int ulp_u = findParent(u);
        int ulp_v = findParent(v);

        if(ulp_u == ulp_v) return;
        if(rank.get(ulp_u) < rank.get(ulp_v)){
            parent.set(ulp_v, ulp_u);
        }
        else if(rank.get(ulp_u) > rank.get(ulp_v)){
            parent.set(ulp_u, ulp_v);
        }
        else{
            parent.set(ulp_u, ulp_v);
            int tempRank = rank.get(ulp_u);
            rank.set(tempRank+1, ulp_u);
        }
    }
}

public class ConnectingGraph {
    public static void main(String[] args) {
        int n = 4;
        //int[][] edges = {{1,2},{2,3},{3,0},{0,1},{0,2},{4,5},{5,6},{7,8}};
        int[][] edges = {{0,1},{0,2},{1,2}};

        System.out.println(connectedGraph(n, edges));
    }

    private static int connectedGraph(int V, int[][] edges){
        int m = edges.length;
        DiSet ds = new DiSet(V);
        int extra = 0;
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if(ds.findParent(u) == ds.findParent(v)){
                extra++;
            }
            else {
                ds.unionByRank(u,v);
            }
        }

        int components = 0;
        for (int i = 0; i < V; i++) {
            if (ds.findParent(i) == i){
                components++;
            }
        }

        int ans = components-1;
        if (extra >= ans){
            return ans;
        }
        return -1;
    }
}
