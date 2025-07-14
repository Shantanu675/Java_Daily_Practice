package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DirectedCycle {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList());
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3));
        list.add(Arrays.asList(4,7));
        list.add(Arrays.asList(5));
        list.add(Arrays.asList(6));
        list.add(Arrays.asList());
        list.add(Arrays.asList(5));
        list.add(Arrays.asList(2,9));
        list.add(Arrays.asList(10));
        list.add(Arrays.asList(8));

        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(detectCycle(list.size()-1, list));
    }

    private static boolean detectCycle(int v, List<List<Integer>> list){
        int[] visit = new int[v+1];
        int[] pathVisit = new int[v+1];

        for (int i = 1; i < v+1; i++) {
            if(visit[i] == 0){
                if(dfs(i, visit, pathVisit, list)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(int node, int[] visit, int[] pathVisit, List<List<Integer>> list){
        visit[node] = 1;
        pathVisit[node] = 1;

        for(int it : list.get(node)){
            if(visit[it] == 0){
                if(dfs(it, visit, pathVisit, list)){
                    return true;
                }
            }else if (pathVisit[it] == 1) {
                return true;
            }
        }
        pathVisit[node] = 0;
        return false;
    }
}
