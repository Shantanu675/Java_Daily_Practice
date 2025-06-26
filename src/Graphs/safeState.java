package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class safeState {
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

    private static List<Integer> isSafeState(int v, List<List<Integer>> list) {
        int[] visit = new int[v];
        int[] pathVisit = new int[v];
        int[] check = new int[v];

        for (int i = 0; i < v; i++) {
            if(visit[i] == 0){
                dfs(i, visit, pathVisit, check, list);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            if(check[i] == 1){
                result.add(i);
            }
        }
        return result;
    }

    public static boolean dfs(int node, int[] visit, int[] pathVisit, int[] check, List<List<Integer>> list){
        visit[node] = 1;
        pathVisit[node] = 1;
        check[node] = 0;

        for (int it : list.get(node)){
            if(visit[it] == 0){
                if(dfs(it, visit, pathVisit, check, list)){
                    check[node] = 0;
                    return true;
                }
            }
            else if(pathVisit[it] == 1){
                check[node] = 0;
                return true;
            }
        }
        check[node] = 1;
        pathVisit[node] = 0;
        return false;
    }
}
