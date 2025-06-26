package Graphs;

import java.util.*;

class M{
    int no;
    int c;

    M(int no, int c){
        this.no = no;
        this.c = c;
    }
}

class Tuple{
    int stops;
    int node;
    int cost;

    Tuple(int stops, int node, int cost){
        this.stops = stops;
        this.node = node;
        this.cost = cost;
    }
}

public class MinFlightPath {
    public static void main(String[] args) {
        int n = 5;
        int[][] flight = {{0,1,5}, {1,2,5}, {3,1,2}, {0,3,2}, {1,4,1}, {4,2,1}};
        int src = 0;
        int dest = 2;
        int k = 2;

        System.out.println(cheapestFlight(n, flight, src, dest, k));
    }

    private static int cheapestFlight(int n, int[][] flight, int src, int dest, int k) {
        List<List<M>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < flight.length; i++) {
            int u = flight[i][0];
            int v = flight[i][1];
            int cost = flight[i][2];

            adj.get(u).add(new M(v, cost));
        }

        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(0, src, 0));

        int[] costs = new int[n];
        for (int i = 0; i < n; i++) {
            costs[i] = (int)1e9;
        }
        costs[src] = 0;

        while(! q.isEmpty()){
            Tuple current = q.poll();
            int stops = current.stops;
            int node = current.node;
            int cost = current.cost;

            if (stops > k) continue;
            for (M it : adj.get(node)){
                int no = it.no;
                int c = it.c;

                int calcCost = cost + c;
                if(calcCost < costs[no] && stops <= k){
                    costs[no] = calcCost;
                    q.offer(new Tuple(stops+1, no, calcCost));
                }
            }
        }
        if(costs[dest] == 1e9) return -1;
        return costs[dest];
    }
}