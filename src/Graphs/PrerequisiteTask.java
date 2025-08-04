package Graphs;

import java.util.*;

public class PrerequisiteTask {
    public static void main(String[] args) {
//        int[][] pre = {{1,0},{2,1},{3,2}};
        int[][] pre = {{1,2},{4,3},{2,4},{4,1}};
        System.out.println(taskComplete(5, pre));
    }

    public static boolean taskComplete(int n, int[][] list){
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < list.length; i++) {
            graph.get(list[i][0]).add(list[i][1]);
        }

        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            for(int it : graph.get(i)){
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if(indegree[i] == 0){
                q.offer(i);
            }
        }

        while(! q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int current = q.poll();
                result.add(current);
                int s = graph.get(current).size();
                for (int it : graph.get(current)) {
                    indegree[it]--;
                    if(indegree[it] == 0){
                        q.offer(it);
                    }
                }
            }
        }
        return result.size() == n;
    }
}
