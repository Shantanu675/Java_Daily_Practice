package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Helps{
    int val;
    int parent;

    Helps(int val, int parent){
        this.val = val;
        this.parent = parent;
    }
}
public class CycleDetectDFS {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
//        list.add(Arrays.asList());
//        list.add(Arrays.asList(2,3));
//        list.add(Arrays.asList(1,5));
//        list.add(Arrays.asList(1,4,6));
//        list.add(Arrays.asList(3));
//        list.add(Arrays.asList(2,7));
//        list.add(Arrays.asList(3));
//        list.add(Arrays.asList(5));

        list.add(Arrays.asList());
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(4));
        list.add(Arrays.asList(3));
        list.add(Arrays.asList(6));
        list.add(Arrays.asList(5,7));
        list.add(Arrays.asList(6));

        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(isDetected(list.size()-1, list));
    }

    private static boolean isDetected(int v, List<List<Integer>> list){
        int[] visit = new int[v+1];

        for (int i = 1; i < v; i++) {
            if(visit[i] == 0){
                if(dfs(new Helps(i,-1), list, visit) == true){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfs(Helps node, List<List<Integer>> list, int[] visit){
        visit[node.val] = 1;

        for(int n : list.get(node.val)){
            if (visit[n] == 0){
                if(dfs(new Helps(n, node.val), list, visit)){
                    return true;
                }
            }
            else if(node.parent != n){
                return true;
            }
        }
        return false;
    }
}
