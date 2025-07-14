package Graphs;

import java.util.*;

public class BipartiteBFS {
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

    private static boolean isBipartite(int v, List<List<Integer>> list) {
        int[] color = new int[v+1];

        for (int i = 0; i < v+1; i++) {
            color[i] = -1;
        }

        for (int i = 1; i < v+1; i++) {
            if(color[i] == -1){
                if(!bfs(i, list, color)){
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean bfs(int node, List<List<Integer>> list, int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        int initialNodeColor = 0;
        color[node] = initialNodeColor;

        while (! q.isEmpty()){
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int currentNode = q.poll();
                int levelSize = list.get(currentNode).size();

                for (int j = 0; j < levelSize; j++) {
                    if(color[list.get(currentNode).get(j)] == 1-initialNodeColor){
                        continue;
                    }
                    else if(color[list.get(currentNode).get(j)] == -1){
                        color[list.get(currentNode).get(j)] = 1-initialNodeColor;
                        q.offer(list.get(currentNode).get(j));
                    }
                    else{
                        return false;
                    }
                }
            }
            initialNodeColor = 1-initialNodeColor;
        }
        return true;
    }
}
