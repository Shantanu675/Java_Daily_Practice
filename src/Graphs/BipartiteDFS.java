package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BipartiteDFS {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
//        list.add(Arrays.asList());
//        list.add(Arrays.asList(2));
//        list.add(Arrays.asList(1,3,6));
//        list.add(Arrays.asList(2,4));
//        list.add(Arrays.asList(3,5,7));
//        list.add(Arrays.asList(4,6));
//        list.add(Arrays.asList(2,5));
//        list.add(Arrays.asList(4,8));
//        list.add(Arrays.asList(7));

        list.add(Arrays.asList());
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(1,3,5));
        list.add(Arrays.asList(2,4));
        list.add(Arrays.asList(3,5,6));
        list.add(Arrays.asList(2,4));
        list.add(Arrays.asList(4));

        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(isBipartite(list.size()-1, list));
    }

    private static boolean isBipartite(int v, List<List<Integer>> list){
        int[] color = new int[v+1];

        for (int i = 0; i < v+1; i++) {
            color[i] = -1;
        }

        for (int i = 1; i < v+1; i++) {
            if(color[i] == -1){
                if(!dfs(i, list, color, 0)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int node, List<List<Integer>> list, int[] color, int col){
        color[node] = col++%2;
        for (int n : list.get(node)){
            if(color[n] == -1){
                dfs(n, list, color, col%2);
            }
            else if(color[n] != col%2){
                return false;
            }
        }
        return true;
    }
}
