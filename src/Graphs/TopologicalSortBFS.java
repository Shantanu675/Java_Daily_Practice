package Graphs;

import java.util.*;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        list.add(Arrays.asList(3));
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(0,1));
        list.add(Arrays.asList(0,2));

        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(Arrays.toString(topological(list.size(), list)));
    }

    public static int[] topological(int v, List<List<Integer>> list) {
        int[] result = new int[v];
        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (int it : list.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int k = 0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int current = q.poll();
                result[k++] = current;

                for (int it : list.get(current)) {
                    indegree[it]--;
                    if(indegree[it] == 0){
                        q.offer(it);
                    }
                }
            }
        }
        return result;
    }
}
