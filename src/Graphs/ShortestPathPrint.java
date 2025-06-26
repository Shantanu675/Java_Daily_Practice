package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class ShortestPathPrint {
    public static void main(String[] args) {
//        int[][] g = {{1,2,2},{2,5,5},{2,3,4},{1,4,1},{4,3,3},{3,5,1}};
        int[][] g = {{1,2,7},{4,5,4},{2,4,3},{1,3,8},{4,3,1},{4,6,5}};
        System.out.println(Arrays.toString(shortestPath(6, 6, g).toArray()));
        //shortestPath(5, 6, g);
    }

    public static List<Integer> shortestPath(int n, int m, int[][] edges){
        int src = 1;
        int dest = n;

        int[] parent = new int[n+1];
        int[] dist = new int[n+1];
        for (int i = 0; i <= n; i++) {
            dist[i] = (int)1e9;
        }

        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            int wt = edges[i][2];

            adj.get(n1).add(Arrays.asList(n2, wt));
            adj.get(n2).add(Arrays.asList(n1, wt));
        }

        List<Integer> ans = new ArrayList<>();

        PriorityQueue<N> pq = new PriorityQueue<>((x,y) -> x.d - y.d);
        pq.offer(new N(src, 0));
        parent[src] = 1;
        dist[src] = 0;

        while (! pq.isEmpty()){
            N current = pq.poll();
            int no = current.n;
            int di = current.d;

            for (List<Integer> li : adj.get(no)){
                int node = li.get(0);
                int distance = li.get(1);

                int calDist = di + distance;
                if(calDist < dist[node]){
                    dist[node] = calDist;
                    parent[node] = no;
                    pq.offer(new N(node, dist[node]));
                }
            }
        }

        int node = n;
        while(parent[node] != node){
            ans.addFirst(parent[node]);
            node = parent[node];
        }
        ans.add(dest);
        ans.add(dist[dest]);
        return ans;
    }
}
