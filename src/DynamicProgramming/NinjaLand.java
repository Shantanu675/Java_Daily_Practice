package DynamicProgramming;

import java.util.Arrays;

public class NinjaLand {
    public static void main(String[] args) {
        int[][] land = {{10, 8, 2},{10, 5, 100},{1, 1, 2}};

        System.out.println(minCost(land));
        System.out.println(minCost1(land));
    }

    private static int minCost1(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return help1(land, land.length-1, land[0].length-1, dp);
    }

    private static int help1(int[][] arr, int i, int j, int[][] dp) {
        if(i == 0 && j == 0) return arr[0][0];
        if(i < 0 || j < 0) return (int)(1e9);
        if(dp[i][j] != -1) return dp[i][j];

        int up = arr[i][j] + help1(arr, i-1, j, dp);
        int left = arr[i][j] + help1(arr, i, j-1, dp);

        return dp[i][j] = Math.min(up, left);
    }

    // Recursion
    private static int minCost(int[][] land) {
        return help(land, land.length-1, land[0].length-1);
    }

    private static int help(int[][] arr, int i, int j) {
        if(i == 0 && j == 0) return arr[0][0];
        if(i < 0 || j < 0) return (int)(1e9);

        int up = arr[i][j] + help(arr, i-1, j);
        int left = arr[i][j] + help(arr, i, j-1);

        return Math.min(up, left);
    }
}
