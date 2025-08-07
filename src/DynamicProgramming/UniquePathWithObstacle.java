package DynamicProgramming;

public class UniquePathWithObstacle {
    public static void main(String[] args) {
        int[][] mat = {
                {0, 0, 0},
                {0, -1, 0},
                {0, 0, 0}
        };
        int m = mat.length;
        int n = mat.length;
        System.out.println(findObstaclePath(m-1, n-1, mat));
        System.out.println(findPathObstacle1(m, n, mat));
        System.out.println(findPathObstacle2(m, n, mat));
//        System.out.println(findPath3(m, n));
    }

    // Tabulation
    private static int findPathObstacle2(int m, int n, int[][] mat) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return help1(m, n, mat, dp);
    }

    private static int help1(int m, int n, int[][] mat, int[][] dp){
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    dp[i][j] = 1;
                    continue;
                }
                if(mat[i][j] == -1) {
                    dp[i][j] = 0;
                    continue;
                }

                int up = 0, left = 0;

                if(i > 0) up = dp[i-1][j];
                if(j > 0) left = dp[i][j-1];

                dp[i][j] = up + left;
            }
        }
        return dp[m-1][n-1];
    }

    // Memoization
    private static int findPathObstacle1(int m, int n, int[][] mat) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return help(m-1, n-1, mat, dp);
    }

    private static int help(int m, int n, int[][] mat, int[][] dp){
        if((n > 0 && m > 0) && mat[m][n] == -1) return 0;
        if(n == 0 && m == 0) return 1;
        if(n < 0 || m < 0) return 0;
        if(dp[n][m] != -1) return dp[n][m];

        int up = findObstaclePath(m-1, n, mat);
        int left = findObstaclePath(m, n-1, mat);

        return dp[m][n] = left + up;
    }

    // Recursion
    private static int findObstaclePath(int m, int n, int[][] mat) {
        if((n > 0 && m > 0) && mat[m][n] == -1) return 0;
        if(n == 0 && m == 0) return 1;
        if(n < 0 || m < 0) return 0;

        int up = findObstaclePath(m-1, n, mat);
        int left = findObstaclePath(m, n-1, mat);

        return left + up;
    }
}
