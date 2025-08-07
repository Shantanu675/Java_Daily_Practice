package DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UniquePath {
    public static void main(String[] args) {
        int m = 3, n = 3;
        System.out.println(findPath(m-1, n-1));
        System.out.println(findPath1(m, n));
        System.out.println(findPath2(m, n));
        System.out.println(findPath3(m, n));
    }

    // Recursion
    private static int findPath(int m, int n) {
        if(m == 0 && n == 0){
            return 1;
        }
        if(m < 0 || n < 0){
            return 0;
        }

        int right = findPath(m, n-1);
        int up = findPath(m-1, n);

        return right + up;
    }

    // Memoization
    private static int findPath1(int m , int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helps1(m-1, n-1, dp);
    }

    private static int helps1(int m, int n, int[][] dp) {
        if(n == 0 && m == 0) return 1;
        if(n < 0 || m < 0) return 0;
        if(dp[m][n] != -1) return dp[m][n];

        int up = helps1(m-1, n, dp);
        int left = helps1(m, n-1, dp);

        return dp[m][n] = up + left;
    }

    // Tabulation
    private static  int findPath2(int m, int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return helps2(m-1, n-1, dp);
    }

    private static int helps2(int m, int n, int[][] dp) {
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int up = 0, left = 0;

                if(i > 0)
                    up = dp[i-1][j];
                if(j > 0)
                    left = dp[i][j-1];

                dp[i][j] = up + left;
            }
        }
        return dp[m][n];
    }

    // Space optimisation
    private static int findPath3(int m, int n) {
        int[] dp = new int[m];
        Arrays.fill(dp, 0);
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }
                int up = 0, right = 0;

                up = dp[j];
                if(j > 0) right = temp[j-1];

                temp[j] = up + right;
            }
            dp = temp;
        }
        return dp[m-1];
    }
}
