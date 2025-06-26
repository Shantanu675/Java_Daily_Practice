package Graphs;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3));
        list.add(Arrays.asList(4,5));
        list.add(Arrays.asList(6));
        list.add(Arrays.asList(6));
        list.add(Arrays.asList(7));
        list.add(Arrays.asList());
        list.add(Arrays.asList(1,9));
        list.add(Arrays.asList(10));
        list.add(Arrays.asList(8));
        list.add(Arrays.asList(9));

        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(isSafeState(list.size(), list));
    }

    public static List<Integer> isSafeState(int v, List<List<Integer>> list) {
        List<List<Integer>> revList = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            revList.add(new ArrayList<>());
        }

        int[] indegree = new int[v];
        for (int i = 0; i < v; i++) {
            for(int it : list.get(i)){
                revList.get(it).add(i);
                indegree[i]++;
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < v; i++) {
            if(indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (! q.isEmpty()){
            int current = q.poll();
            safeNodes.add(current);

            for (int it : revList.get(current)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.offer(it);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
