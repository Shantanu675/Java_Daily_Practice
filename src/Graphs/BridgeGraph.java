package Graphs;

import javax.swing.event.ListDataEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BridgeGraph {
    public static void main(String[] args) {
        List<List<Integer>> connection = new ArrayList<>();
        connection.add(Arrays.asList(1,2));
        connection.add(Arrays.asList(2,3));
        connection.add(Arrays.asList(3,4));
        connection.add(Arrays.asList(1,4));
        connection.add(Arrays.asList(4,5));
        connection.add(Arrays.asList(5,6));
        connection.add(Arrays.asList(6,7));
        connection.add(Arrays.asList(6,9));
        connection.add(Arrays.asList(7,8));
        connection.add(Arrays.asList(9,8));
        connection.add(Arrays.asList(8,10));
        connection.add(Arrays.asList(10,11));
        connection.add(Arrays.asList(10,12));
        connection.add(Arrays.asList(11,12));

        System.out.println(Arrays.toString(criticalConnections(12, connection).toArray()));
    }

    static int timer = 1;

    private static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connection) {
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < connection.size(); i++) {
            int u = connection.get(i).get(0);
            int v = connection.get(i).get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] vis = new int[n+1];
        int[] tin = new int[n+1];
        int[] low = new int[n+1];

        List<List<Integer>> bridges = new ArrayList<>();
        dfs(1, -1, adj, bridges, vis, tin, low);

        return bridges;
    }

    private static void dfs(int node, int parent, List<List<Integer>> adj, List<List<Integer>> bridges, int[] vis, int[] tin, int[] low){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;

        for (int it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, adj, bridges, vis, tin, low);
                low[node] = Math.min(low[it], low[node]);

                if(low[it] > tin[node]){
                    bridges.add(new ArrayList<>(Arrays.asList(it, node)));
                }
            }
            else {
                low[node] = Math.min(low[it], low[node]);
            }
        }
    }
}
