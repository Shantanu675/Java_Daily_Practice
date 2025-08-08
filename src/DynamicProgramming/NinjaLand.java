package DynamicProgramming;

import java.util.Arrays;

public class NinjaLand {
    public static void main(String[] args) {
        int[][] land = {{10, 8, 2},{10, 5, 100},{1, 1, 2}};

        System.out.println(minCost(land));
        System.out.println(minCost1(land));
        System.out.println(minCost2(land));
        System.out.println(minCost3(land));
    }

    // Space Optization
    private static int minCost3(int[][] land) {
        int[] prev = new int[land[0].length];
        Arrays.fill(prev, (int)1e9);

        for(int i = 0; i < land.length; i++) {
            int[] temp = new int[land[0].length];
            for (int j = 0; j < land[0].length; j++) {
                if(i == 0 && j == 0) {
                    temp[j] = land[0][0];
                    continue;
                }
                int left = (int)(1e9);
                int up = prev[j] + land[i][j];
                if(j > 0) left = temp[j-1] + land[i][j];

                temp[j] = Math.min(up, left);
            }
            prev = temp;
        }
        return prev[land[0].length-1];
    }

    // Tabulation
    private static int minCost2(int[][] land) {
        int[][] dp = new int[land.length][land[0].length];
        return help2(land, land.length, land[0].length, dp);
    }

    private static int help2(int[][] arr, int n, int m, int[][] dp){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0) {
                    dp[0][0] = arr[0][0];
                    continue;
                }

                int left = (int)(1e9);
                int up = (int)(1e9);

                if(i > 0) up = arr[i][j] + dp[i-1][j];
                if(j > 0) left = arr[i][j] + dp[i][j-1];

                dp[i][j] = Math.min(up, left);
            }
        }
        return dp[n-1][m-1];
    }

    // Memoization
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
