package Graphs;

import java.util.*;

class DS {
    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    public DS(int n){
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

class Edge implements Comparable<Edge> {
    int src;
    int des;
    int wet;

    public Edge(int src, int des, int wet){
        this.src = src;
        this.des = des;
        this.wet = wet;
    }

    @Override
    public int compareTo(Edge other){
        return this.wet - other.wet;
    }
}

public class KruskalAlgo {
    public static void main(String[] args) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        int n = 6;
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(1).add(Arrays.asList(2, 2));
        adj.get(1).add(Arrays.asList(4, 1));
        adj.get(1).add(Arrays.asList(5, 4));
        adj.get(2).add(Arrays.asList(1, 2));
        adj.get(2).add(Arrays.asList(3, 3));
        adj.get(2).add(Arrays.asList(4, 3));
        adj.get(2).add(Arrays.asList(6, 7));
        adj.get(3).add(Arrays.asList(2, 3));
        adj.get(3).add(Arrays.asList(4, 5));
        adj.get(3).add(Arrays.asList(6, 8));
        adj.get(4).add(Arrays.asList(1, 1));
        adj.get(4).add(Arrays.asList(2, 3));
        adj.get(4).add(Arrays.asList(3, 5));
        adj.get(4).add(Arrays.asList(5, 9));
        adj.get(5).add(Arrays.asList(1, 4));
        adj.get(5).add(Arrays.asList(4, 9));
        adj.get(6).add(Arrays.asList(2, 7));
        adj.get(6).add(Arrays.asList(3, 8));

        System.out.println(kruskal(n, adj));
    }

    public static int kruskal(int v, List<List<List<Integer>>> adj){
        int sum = 0;
        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i < v+1; i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                int src = i;
                int des = adj.get(i).get(j).get(0);
                int wt = adj.get(i).get(j).get(1);

                edges.add(new Edge(src, des, wt));
            }
        }

        Collections.sort(edges);
        DS ds = new DS(v);

        for (int i = 0; i < edges.size(); i++) {
            int w = edges.get(i).wet;
            int s = edges.get(i).src;
            int d = edges.get(i).des;

            if(ds.findParent(s) != ds.findParent(d)){
                sum += w;
                ds.unionByRank(s,d);
            }
        }
        return sum;
    }
}
