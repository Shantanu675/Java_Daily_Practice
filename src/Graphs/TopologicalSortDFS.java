package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList());
        list.add(Arrays.asList());
        list.add(Arrays.asList(3));
        list.add(Arrays.asList(1));
        list.add(Arrays.asList(0,1));
        list.add(Arrays.asList(0,2));

        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(topological(list.size(), list));
    }

    public static List<Integer> topological(int v, List<List<Integer>> list){
        int[] visit = new int[v];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < v; i++) {
            if(visit[i] == 0){
                dfs(i, visit, list, stack);
            }
        }

        List<Integer> result = new ArrayList<>();
        while(! stack.empty()) {
            result.add(stack.pop());
        }

        return result;
    }

    public static void dfs(int node, int[] visit, List<List<Integer>> list, Stack<Integer> stack){
        visit[node] = 1;

        for(int it : list.get(node)){
            if(visit[it] == 0){
                dfs(it, visit, list, stack);
            }
        }
        stack.push(node);
    }
}
