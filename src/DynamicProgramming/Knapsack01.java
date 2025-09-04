package DynamicProgramming;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        int maxWeight = 50;
        System.out.println(knapsack01(wt, val, wt.length-1, maxWeight));
        System.out.println(knapsack01_1(wt, val, wt.length, maxWeight));
        System.out.println(knapsack01_2(wt, val, wt.length, maxWeight));
        System.out.println(knapsack01_3(wt, val, wt.length, maxWeight));
        System.out.println(knapsack01_4(wt, val, wt.length, maxWeight));
    }

    //More Optimisation
    private static int knapsack01_4(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W+1];

        for (int i = wt[0]; i <= W; i++) prev[i] = val[0];

        for (int i = 1; i < n; i++) {
            for (int j = W; j >= 0; j--) {
                int notPick = prev[j];
                int pick = Integer.MIN_VALUE;
                if(j >= wt[i]) {
                    pick =  val[i] + prev[j - wt[i]];
                }
                prev[j] = Math.max(pick, notPick);
            }
        }
        return prev[W];
    }

    //Space Optimisation
    private static int knapsack01_3(int[] wt, int[] val, int n, int W) {
        int[] prev = new int[W+1];

        for (int i = wt[0]; i <= W; i++) prev[i] = val[0];

        for (int i = 1; i < n; i++) {
            int[] curr = new int[W+1];
            for (int j = 0; j <= W; j++) {
                int notPick = prev[j];
                int pick = Integer.MIN_VALUE;
                if(j >= wt[i]) {
                    pick =  val[i] + prev[j - wt[i]];
                }
                curr[j] = Math.max(pick, notPick);
            }
            prev = curr;
        }
        return prev[W];
    }

    //Tabulation
    private static int knapsack01_2(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];

        for (int i = wt[0]; i <= W; i++) dp[0][i] = val[0];

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                int notPick = dp[i-1][j];
                int pick = Integer.MIN_VALUE;
                if(j >= wt[i]) {
                    pick =  val[i] + dp[i-1][j - wt[i]];
                }
                dp[i][j] = Math.max(pick, notPick);
            }
        }
        return dp[n-1][W];
    }

    //Memoization
    private static int knapsack01_1(int[] wt, int[] val, int n, int W) {
        int[][] dp = new int[n][W+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= W; j++) {
                dp[i][j] = -1;
            }
        }

        return helper(wt, val, n-1, W, dp);
    }

    private static int helper(int[] wt, int[] val, int n, int W, int[][] dp) {
        if(n == 0) {
            if(wt[0] <= W) return val[0];
            else return 0;
        }
        if(dp[n][W] != -1) return dp[n][W];

        int notPick = helper(wt, val, n-1, W, dp);
        int pick = Integer.MIN_VALUE;
        if(W >= wt[n]) {
            pick =  val[n] + helper(wt, val, n-1, W-wt[n], dp);
        }

        return Math.max(notPick, pick);
    }

    //Recursion
    private static int knapsack01(int[] wt, int[] val, int n, int W) {
        if(n == 0) {
            if(wt[0] <= W) return val[0];
            else return 0;
        }

        int notPick = knapsack01(wt, val, n-1, W);
        int pick = Integer.MIN_VALUE;
        if(W >= wt[n]) {
            pick =  val[n] + knapsack01(wt, val, n-1, W-wt[n]);
        }

        return Math.max(notPick, pick);
    }


}
