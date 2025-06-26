package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Nod{
    int dist;
    int node;

    Nod(int dist, int node){
        this.dist = dist;
        this.node = node;
    }
}

public class DJPriorityQueue {
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

    private static int[] dijkstra(int v, List<List<List<Integer>>> adj, int src) {
        PriorityQueue<Nod> pq = new PriorityQueue<>((x,y) -> x.dist - y.dist);

        int[] dist = new int[v];
        for (int i = 0; i < v; i++) {
            dist[i] = (int)1e9;
        }

        dist[src] = 0;
        pq.add(new Nod(0, src));

        while (! pq.isEmpty()){
            Nod current = pq.poll();
            int distance = current.dist;
            int node = current.node;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int wt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if(distance + wt < dist[adjNode]){
                    dist[adjNode] = distance + wt;
                    pq.add(new Nod(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}
