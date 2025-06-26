package Graphs;

import java.util.*;

class N{
    int n;
    int d;

    N(int n, int d){
        this.n = n;
        this.d = d;
    }
}

// using set not possible in java
// not even using HashSet and TreeSet

public class DJSet {
    public static void main(String[] args) {
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(Arrays.asList(1,4));
        adj.get(0).add(Arrays.asList(2,4));
        adj.get(1).add(Arrays.asList(0,4));
        adj.get(1).add(Arrays.asList(2,2));
        adj.get(2).add(Arrays.asList(0,4));
        adj.get(2).add(Arrays.asList(1,2));
        adj.get(2).add(Arrays.asList(3,3));
        adj.get(2).add(Arrays.asList(4,1));
        adj.get(2).add(Arrays.asList(5,6));
        adj.get(3).add(Arrays.asList(2,3));
        adj.get(3).add(Arrays.asList(5,2));
        adj.get(4).add(Arrays.asList(2,1));
        adj.get(4).add(Arrays.asList(5,3));
        adj.get(5).add(Arrays.asList(2,6));
        adj.get(5).add(Arrays.asList(3,2));
        adj.get(5).add(Arrays.asList(4,3));

        System.out.println(Arrays.toString(dijkstra(adj.size(), adj, 0)));
    }

    private static int[] dijkstra(int v, List<List<List<Integer>>> adj, int s) {
        PriorityQueue<N> pq = new PriorityQueue<>((x,y) -> x.d - y.d);

        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = (int)1e9;
        }
        dist[s] = 0;

        pq.offer(new N(s, 0));

        while (! pq.isEmpty()){
            N current = pq.poll();
            int n = current.n;
            int d = current.d;

            for (List<Integer> li : adj.get(n)){
                int node = li.get(0);
                int dis = li.get(1);

                int calDis = d + dis;
                if(calDis < dist[node]){
                    dist[node] = calDis;
                    pq.offer(new N(node, dist[node]));
                }
            }
        }
        return dist;
    }
}
