package Graphs;

import java.util.*;

class Help{
    int val;
    int parent;

    Help(int val, int parent){
        this.val = val;
        this.parent = parent;
    }
}

public class CycleDetectBFS {
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
        list.add(Arrays.asList(6,7));
        list.add(Arrays.asList(5,7));
        list.add(Arrays.asList(5,6));

        System.out.println(Arrays.toString(list.toArray()));

        System.out.println(isDetected(list.size()-1, list));
    }

    private static boolean isDetected(int v, List<List<Integer>> list) {
        int[] visit = new int[v+1];
        for (int i = 1; i < v+1; i++) {
            if(visit[i] == 0){
                if(bfs(i, list, visit)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean bfs(int node, List<List<Integer>> list, int[]visit){
        Queue<Help> q = new LinkedList<>();
        q.offer(new Help(node, -1));
        visit[node] = 1;

        while(! q.isEmpty()){
            int sizeQueue = q.size();
            for (int i = 0; i < sizeQueue; i++) {
                Help currentNode = q.poll();

                for (int j = 0; j < list.get(currentNode.val).size(); j++) {
                    if(visit[list.get(currentNode.val).get(j)] == 1){
                        if(currentNode.parent == list.get(currentNode.val).get(j)){
                            continue;
                        }
                        else {
                            return true;
                        }
                    }
                    else if(visit[list.get(currentNode.val).get(j)] == 0) {
                        q.offer(new Help(list.get(currentNode.val).get(j), currentNode.val));
                        visit[list.get(currentNode.val).get(j)] = 1;
                    }
                }
            }
        }
        return false;
    }
}