package Graphs;

import java.util.HashSet;
//import java.util.concurrent.atomic.AtomicInteger;

public class MakeLargeIsland {
    public static void main(String[] args) {
        int[][] arr = {{1, 1, 0, 1, 1},
                    {1, 1, 0, 1, 1},
                    {1, 1, 0, 1, 1},
                    {0, 0, 1, 0, 0},
                    {0, 0, 1, 1, 1},
                    {0, 0, 1, 1, 1},
        };

        System.out.println(makeLargeIsland(arr));
    }

    private static int makeLargeIsland(int[][] earth) {
        int n = earth.length;
        int m = earth[0].length;
        int maxSize = 0;
        DisjointSet ds = new DisjointSet((n*m)-1);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, -1, 0, 1};

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if(earth[row][col] == 0) continue;
                int node = (row * m) + col;

                for (int k = 0; k < 4; k++) {
                    int newRow = delRow[k] + row;
                    int newCol = delCol[k] + col;

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && earth[newRow][newCol] == 1){
                        int anotherNode = (newRow * m) + newCol;

                        if(ds.findParent(node) != ds.findParent(anotherNode)) {
                            ds.unionBySize(node, anotherNode);
                        }
                    }
                }
            }
        }

        HashSet<Integer> set = new HashSet<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < m; col++) {
                if(earth[row][col] == 1){
                    continue;
                }
                int size = 1;

                for (int k = 0; k < 4; k++) {
                    int newRow = delRow[k] + row;
                    int newCol = delCol[k] + col;

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && earth[newRow][newCol] == 1){
                        int anotherNode = (newRow * m) + newCol;
                        set.add(ds.findParent(anotherNode));
                    }
                }
                for (Integer it : set){
                    size += ds.size.get(it);
                }
                maxSize = Math.max(maxSize, size);
            }
        }
        return maxSize;
    }
}
