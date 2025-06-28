package Graphs;

import java.util.HashSet;

public class MaxStonesRem {
    public static void main(String[] args) {
        //int[][] stones = {{0, 0}, {0, 2}, {2, 3}, {3, 1}, {3, 2}, {4, 3}};
        int[][] stones = {{0,0},{1,1},{2,2},{2,3},{2,4},{3,2}};
        int n = stones.length;

        System.out.println(maxRemove(n, stones));
    }

    private static int maxRemove(int n, int[][] stones) {
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < n; i++) {
            maxRow = Math.max(maxRow, stones[i][0]);
            maxCol = Math.max(maxCol, stones[i][1]);
        }

        DisjointSet ds = new DisjointSet(maxRow + maxCol + 1);
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int rowNode = stones[i][0];
            int colNode = stones[i][1] + maxRow + 1;
            ds.unionByRank(rowNode, colNode);
            set.add(rowNode);
            set.add(colNode);
        }

        int count = 0;
        for (Integer it : set){
            if(ds.findParent(it) == it){
                count++;
            }
        }
        return n - count;
    }
}