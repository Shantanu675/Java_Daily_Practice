package Graphs;

import java.util.*;

import static Graphs.MatrixToList.createList;

public class BFS {
    public static void main(String[] args) {
        int[][] graph = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0, 1, 0, 0, 0},
                        {0, 1, 1, 1, 1, 0, 0, 0, 0, 0},
                        {0, 0, 1, 1, 0, 0, 0, 0, 0, 0},
                        {0, 0, 1, 0, 1, 1, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 1, 0, 0, 1, 0},
                        {0, 1, 0, 0, 0, 0, 1, 1, 0, 1},
                        {0, 0, 0, 0, 0, 0, 1, 1, 1, 0},
                        {0, 0, 0, 0, 0, 1, 0, 1, 1, 0},
                        {0, 0, 0, 0, 0, 0, 1, 0, 0, 1}};

        //MatrixToList m = new MatrixToList();
        List<List<Integer>> g = createList(graph);
        System.out.println(Arrays.toString(g.toArray()));
        List<Integer> ans = bfs(g);
        System.out.println(Arrays.toString(ans.toArray()));
    }

    private static List<Integer> bfs(List<List<Integer>> graph) {
        List<Integer> list = new ArrayList<>();
        if(graph == null || graph.isEmpty()){
            return list;
        }

        int[] visit = new int[graph.size()];
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visit[1] = 1;

        while(! q.isEmpty()){
            int sizeLevel = q.size();
            for (int i = 0; i < sizeLevel; i++) {
                int currentNode = q.poll();
                list.add(currentNode);

                int a = graph.get(currentNode).size();
                for (int j = 0; j < a; j++) {

                    if(visit[graph.get(currentNode).get(j)] == 0){
                        q.offer(graph.get(currentNode).get(j));
                        visit[graph.get(currentNode).get(j)] = 1;
                    }
                }
            }
        }
        return list;
    }
}

