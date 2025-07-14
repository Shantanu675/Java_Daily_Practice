package Graphs;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class AlienDict{
    public static void main(String[] args) {
        String[] arr = {"baa", "abcd", "abca", "cab", "cad"};
        int n = arr.length;
        int k = 4;
//        String[] arr = {"abc", "baf", "ade"};
//        int n = arr.length;
//        int k = 6;
        System.out.println(foundOrder(arr, n, k));
    }

    public static void topo(int node, List<List<Integer>> graph, int[] visit, Stack<Integer> stack){
        visit[node] = 1;
        for(int it : graph.get(node)){
            if(visit[it] == 0){
                topo(it, graph, visit, stack);
            }
        }
        stack.push(node);
    }

    public static String foundOrder(String[] dict, int n, int k){
        // Creation of Graph using given info
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < k; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < n-1; i++){
            String s1 = dict[i];
            String s2 = dict[i+1];

            int len = Math.min(s1.length(), s2.length());
            for(int j = 0; j < len; j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    graph.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    break;
                }
            }
        }

        // Apply Topo Sort
        String result = "";
        int[] visit = new int[k];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < k; i++){
            if(visit[i] == 0){
                topo(i, graph, visit, stack);
            }
        }

        if(stack.size() == k){
            while(!stack.empty()){
                result += (char)(stack.pop()+97);
            }
        }
        else{
            result = "0";
        }

        return result;
    }
}
