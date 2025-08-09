package DynamicProgramming;

public class Triangle {
    public static void main(String[] args) {
        int[][] triangle = {{1}, {2 ,3}, {3, 6, 7}, {8, 9, 6, 10}};
        System.out.println(minCost(triangle, triangle.length));
        System.out.println(minCost1(triangle, triangle.length));
        System.out.println(minCost2(triangle, triangle.length));
        System.out.println(minCost3(triangle, triangle.length));
    }

    // Recursion
    public static int minCost(int[][] triangle, int n) {
        return help(0, 0, triangle, n);
    }

    public static int help(int i, int j, int[][] triangle, int n) {
        if(i == n) return 0;

        int down = triangle[i][j] + help(i+1, j, triangle, n);
        int diag = triangle[i][j] + help(i+1, j+1, triangle, n);

        return Math.min(down, diag);
    }

    // Memoization
    public static int minCost1(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return help1(0, 0, triangle, n, dp);
    }

    public static int help1(int i, int j, int[][] triangle, int n, int[][] dp) {
        if(i == n) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int down = triangle[i][j] + help1(i+1, j, triangle, n, dp);
        int diag = triangle[i][j] + help1(i+1, j+1, triangle, n, dp);

        return dp[i][j] = Math.min(down, diag);
    }

    // Tabulation
    public static int minCost2(int[][] triangle, int n) {
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return help2(triangle, n, dp);
    }

    public static int help2(int[][] triangle, int n, int[][] dp) {
        for (int i = 0; i < n; i++) {
            dp[n-1][i] = triangle[n-1][i];
        }

        for(int i = n-2; i >= 0; i--) {
            for(int j = i; j >= 0; j--) {
                int down = triangle[i][j] + dp[i+1][j];
                int diag = triangle[i][j] + dp[i+1][j+1];

                dp[i][j] = Math.min(down, diag);
            }
        }
        return dp[0][0];
    }

    // Space Optimisation
    public static int minCost3(int[][] triangle, int n) {
        int[] prev = new int[n];
        for(int i = 0; i < n; i++) {
            prev[i] = triangle[n-1][i];
        }

        for(int i = n-2; i >= 0; i--) {
            int[] curr = new int[n];
            for(int j = i; j >= 0; j--) {
                int down = triangle[i][j] + prev[j];
                int diag = triangle[i][j] + prev[j+1];

                curr[j] = Math.min(down, diag);
            }
            prev = curr;
        }
        return prev[0];
    }
}
