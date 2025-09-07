package DynamicProgramming;

public class KnapsackInfiniteSupply {
    public static void main(String[] args) {
        int[] wt = {2, 4, 6};
        int[] val = {5, 11, 13};
        int target = 10;
        System.out.println(stealObj(wt, val, 3, target));
        System.out.println(stealObj1(wt, val, 3, target));
        System.out.println(stealObj2(wt, val, 3, target));
        System.out.println(stealObj3(wt, val, 3, target));
        System.out.println(stealObj4(wt, val, 3, target));
    }

    //2Arr -> 1Arr
    private static int stealObj4(int[] wt, int[] val, int n, int target) {
        int[] prev = new int[target+1];

        for (int W = 0; W <= target; W++) {
            prev[W] = (W / wt[0]) * val[0];
        }

        for (int indx = 1; indx < n; indx++) {
            for (int W = 0; W <= target; W++) {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if(wt[indx] <= W) {
                    take = val[indx] + prev[W-wt[indx]];
                }

                prev[W] = Math.max(take, notTake);
            }
        }
        return prev[target];
    }

    //Space Optimisation
    private static int stealObj3(int[] wt, int[] val, int n, int target) {
        int[] prev = new int[target+1];

        for (int W = 0; W <= target; W++) {
            prev[W] = (W / wt[0]) * val[0];
        }

        for (int indx = 1; indx < n; indx++) {
            int[] curr = new int[target+1];
            for (int W = 0; W <= target; W++) {
                int notTake = 0 + prev[W];
                int take = Integer.MIN_VALUE;
                if(wt[indx] <= W) {
                    take = val[indx] + curr[W-wt[indx]];
                }

                curr[W] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[target];
    }

    //Tabulation
    private static int stealObj2(int[] wt, int[] val, int n, int target) {
        int[][] dp = new int[n][target+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        for (int W = 0; W <= target; W++) {
            dp[0][W] = (W / wt[0]) * val[0];
        }

        for (int indx = 1; indx < n; indx++) {
            for (int W = 0; W <= target; W++) {
                int notTake = 0 + dp[indx-1][W];
                int take = Integer.MIN_VALUE;
                if(wt[indx] <= W) {
                    take = val[indx] + dp[indx][W-wt[indx]];
                }

                dp[indx][W] = Math.max(take, notTake);
            }
        }
        return dp[n-1][target];
    }

    //Memoization
    private static int stealObj1(int[] wt, int[] val, int n, int target) {
        int[][] dp = new int[n][target+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return helper1(wt, val, n-1, target, dp);
    }

    private static int helper1(int[] wt, int[] val, int indx, int target, int[][] dp) {
        if(indx == 0) {
            return (target / wt[0]) * val[0];
        }

        if(dp[indx][target] != -1) return dp[indx][target];

        int notTake = 0 + helper1(wt, val, indx-1, target, dp);
        int take = Integer.MIN_VALUE;
        if(wt[indx] <= target) {
            take = val[indx] + helper1(wt, val, indx, target-wt[indx], dp);
        }

        return dp[indx][target] = Math.max(take, notTake);
    }

    //Recursion
    private static int stealObj(int[] wt, int[] val, int n, int target) {
        return helper(wt, val, n-1, target);
    }

    private static int helper(int[] wt, int[] val, int indx, int target) {
        if(indx == 0) {
            return (target / wt[0]) * val[0];
        }

        int notTake = 0 + helper(wt, val, indx-1, target);
        int take = Integer.MIN_VALUE;
        if(wt[indx] <= target) {
            take = val[indx] + helper(wt, val, indx, target-wt[indx]);
        }

        return Math.max(take, notTake);
    }
}
