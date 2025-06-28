package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArticulationPoints {
    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();

        adj.add(Arrays.asList(1,2,3));
        adj.add(Arrays.asList(0));
        adj.add(Arrays.asList(0,3,4,5));
        adj.add(Arrays.asList(0,2));
        adj.add(Arrays.asList(2,6));
        adj.add(Arrays.asList(2,6));
        adj.add(Arrays.asList(4,5));

        System.out.println(pointsOfArticulation(7, adj));
    }

    private static ArrayList<Integer> pointsOfArticulation(int n, List<List<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();

        int[] vis = new int[n];
        int[] mark = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        for (int i = 0; i < n; i++) {
            if(vis[i] == 0) {
                dfs(i, -1, adj, vis, mark, tin, low);
            }
        }

        for (int i = 0; i < n; i++) {
            if(mark[i] == 1){
                ans.add(i);
            }
        }

        if(ans.size() == 0){
            ans.add(-1);
        }

        return ans;
    }

    static int timer = 0;
    private static void dfs(int node, int parent, List<List<Integer>> adj, int[] vis, int[]mark, int[] tin, int[] low){
        vis[node] = 1;
        tin[node] = low[node] = timer;
        timer++;

        int child = 0;
        for(int it : adj.get(node)){
            if(it == parent) continue;
            if(vis[it] == 0){
                dfs(it, node, adj, vis, mark, tin, low);
                low[node] = Math.min(low[node], low[it]);

                if(low[it] >= tin[node] && parent != -1){
                    mark[node] = 1;
                }
                child++;
            }
            else {
                low[node] = Math.min(low[node], tin[it]);
            }
        }
        if(child > 1 && parent == -1){
            mark[node] = 1;
        }
    }
}
