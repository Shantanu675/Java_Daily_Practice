package Graphs;

import java.util.HashSet;

public class MaxConnectedGroups {
    public static void main(String[] args) {
        int[][] grid = {
                        {1, 1, 0, 1, 1},
                        {1, 1, 0, 1, 1},
                        {1, 1, 0, 1, 1},
                        {0, 0, 1, 0, 0},
                        {0, 0, 1, 1, 1},
                        {0, 0, 1, 1, 1}
                       };

        System.out.println(maxConnections(grid));
    }

    private static int maxConnections(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        DisjointSet ds = new DisjointSet(n*m);

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int node = (i * m) + j;

                if(grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int newRow = delRow[k] + i;
                        int newCol = delCol[k] + j;

                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] == 1) {
                            int anotherNode = newRow * m + newCol;
                            if (ds.findParent(node) != ds.findParent(anotherNode)) {
                                ds.unionBySize(node, anotherNode);
                            }
                        }
                    }
                }
            }
        }
        int mx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j] == 1){
                    continue;
                }
                HashSet<Integer> set = new HashSet<>();
                for (int k = 0; k < 4; k++) {
                    int newRow = delRow[k] + i;
                    int newCol = delCol[k] + j;

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        if (grid[newRow][newCol] == 1) {
                            set.add(ds.findParent(newRow * m + newCol));
                        }
                    }
                }
                int size = 0;
                for (Integer it : set){
                    size += ds.size.get(it);
                }
                mx = Math.max(mx, size);
            }
        }
        for (int cell = 0; cell < n * m; cell++) {
            mx = Math.max(mx, ds.size.get(ds.findParent(cell)));
        }
        return  mx;
    }
}
