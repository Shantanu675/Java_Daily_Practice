package Graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class P{
    int time;
    int node;

    P(int node, int time){
        this.node = node;
        this.time = time;
    }
}

class Elem{
    int t;
    int n;

    Elem(int t, int n){
        this.t = t;
        this.n = n;
    }
}

public class NoWaysToArrive {
    public static void main(String[] args) {
        int[][] roads = {{0,4,5}, {0,6,7}, {0,1,2}, {1,3,3}, {1,2,3}, {2,5,1}, {3,6,3}, {3,5,1}, {4,6,2}, {5,6,1}};
        int n = 7;

        System.out.println(minWays(n, roads));
    }

    private static int minWays(int n, int[][] roads) {
        List<List<P>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int t = roads[i][2];

            adj.get(u).add(new P(v, t));
            adj.get(v).add(new P(u, t));
        }

        int[] ways = new int[n];
        int[] times = new int[n];
        for (int i = 0; i < n; i++) {
            ways[i] = 0;
            times[i] = (int)1e9;
        }

        PriorityQueue<Elem> pq = new PriorityQueue<>((x,y) -> x.t - y.t);
        pq.offer(new Elem(0, 0));

        ways[0] = 1;
        times[0] = 0;

        int mod = (int)(1e9 + 7);
        while(! pq.isEmpty()){
            Elem curr = pq.poll();
            int t = curr.t;
            int no = curr.n;

            for (P it : adj.get(no)){
                int time = it.time;
                int node = it.node;

                int calTime = t + time;
                if(calTime == times[node]){
                    ways[node] = (ways[node] + ways[no]) % mod;
                } else if (calTime < times[node]) {
                    ways[node] = 1;
                    times[node] = calTime;
                    pq.offer(new Elem(calTime, node));
                }
            }
        }
        return ways[n-1] % mod;
    }
}