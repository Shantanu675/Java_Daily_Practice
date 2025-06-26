package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BellmanFord {
    public static void main(String[] args) {
        List<List<Integer>> graph = new ArrayList<>();
//        graph.add(Arrays.asList(0, 1, 5));
//        graph.add(Arrays.asList(1, 0, 3));
//        graph.add(Arrays.asList(1, 2, -1));
//        graph.add(Arrays.asList(2, 0 , 1));

        //graph with negative cycle
        graph.add(Arrays.asList(0, 1, -2));
        graph.add(Arrays.asList(2, 0, 2));
        graph.add(Arrays.asList(1, 2, -1));

        System.out.println(Arrays.toString(bellmanFor(3, graph, 0)));
    }

    private static int[] bellmanFor(int n, List<List<Integer>> edges, int src) {
        int[] dist = new int[n];

        Arrays.fill(dist, (int) 1e8);
        dist[src] = 0;

        for (int i = 0; i < n-1; i++) {
            for (List<Integer> it : edges){
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Nth iteration to check negative cycle exist or not in directed graph
        for (List<Integer> it : edges){
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if(dist[u] != 1e8 && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
