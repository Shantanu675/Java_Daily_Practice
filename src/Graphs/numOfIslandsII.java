package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class numOfIslandsII {
    public static void main(String[] args) {
        int n = 4;
        int m = 5;

        //int[][] arr = {{0,0},{0,0},{1,1},{1,0},{0,1},{0,3},{1,3},{0,4},{3,2},{2,2},{1,2},{0,2}};
        int[][] arr = {{1,1},{0,1},{3,3},{3,4}};

        System.out.println(Arrays.toString(numOfIslands(n, m, arr).toArray()));
    }

    private static List<Integer> numOfIslands(int n, int m, int[][] arr) {
        DiSet ds = new DiSet(n*m);

        List<Integer> result = new ArrayList<>();

        int[] delRow = {1, 0, -1, 0};
        int[] delCol = {0, 1, 0, -1};

        int count = 0;

        int[][] visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = 0;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            int row = arr[i][0];
            int col = arr[i][1];
            int node = row * m + col;

            if(visit[row][col] == 0) {
                count++;
                visit[row][col] = 1;
                //result.add(count);
            }

            for (int j = 0; j < 4; j++) {
                int newRow = delRow[j] + row;
                int newCol = delCol[j] + col;

                if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && visit[newRow][newCol] == 1){
                    int anotherNode = newRow * m + newCol;
                    if(ds.findParent(node) != ds.findParent(anotherNode)){
                        ds.unionByRank(node, anotherNode);
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}
