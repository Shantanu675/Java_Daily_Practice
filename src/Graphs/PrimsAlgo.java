package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Com{
    int wt;
    int node;
    int parent;

    public Com(int wt, int node, int parent) {
        this.wt = wt;
        this.node = node;
        this.parent = parent;
    }
}

public class PrimsAlgo {
    public static void main(String[] args) {
        int n = 5;
        List<List<List<Integer>>> adj = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(Arrays.asList(1,2));
        adj.get(0).add(Arrays.asList(2,1));
        adj.get(1).add(Arrays.asList(0,2));
        adj.get(1).add(Arrays.asList(2,1));
        adj.get(2).add(Arrays.asList(0,1));
        adj.get(2).add(Arrays.asList(1,1));
        adj.get(2).add(Arrays.asList(3,2));
        adj.get(2).add(Arrays.asList(4,2));
        adj.get(3).add(Arrays.asList(2,2));
        adj.get(3).add(Arrays.asList(4,1));
        adj.get(4).add(Arrays.asList(2,2));
        adj.get(4).add(Arrays.asList(3,1));

        System.out.println(mst(n, adj));
    }

    private static int mst(int n, List<List<List<Integer>>> adj) {
        int[] visit = new int[n];
        Arrays.fill(visit, 0);

        PriorityQueue<Com> pq = new PriorityQueue<>((x,y) -> x.wt - y.wt);
        pq.offer(new Com(0, 0, 0));

        int sum = 0;
        List<List<Integer>> result = new ArrayList<>();

        while (! pq.isEmpty()){
            Com curr = pq.poll();
            int wt = curr.wt;
            int node = curr.node;
            int parent = curr.parent;

            if(visit[node] == 0){
                sum += wt;
                visit[node] = 1;
            } 

            for (List<Integer> it : adj.get(node)){
                int dest = it.get(0);
                int weight = it.get(1);

                if(visit[dest] == 0) {
                    pq.offer(new Com(weight, dest, node));
                }
            }
        }
        System.out.println(Arrays.toString(result.toArray()));
        return sum;
    }
}
