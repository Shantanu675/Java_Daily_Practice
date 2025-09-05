package DynamicProgramming;

public class TotalWaysFullfillTargetWithCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 4;
        System.out.println(totalWays(coins, target));
        System.out.println(totalWays1(coins, target));
        System.out.println(totalWays2(coins, coins.length, target));
        System.out.println(totalWays3(coins, coins.length, target));
    }

    //Space Optimisation
    private static int totalWays3(int[] coins, int n, int target) {
        int[] prev = new int[target+1];

        for(int T = 0; T <= target; T++) {
            if(T % coins[0] == 0) prev[T] = 1;
        }

        for (int indx = 1; indx < n; indx++) {
            int[] curr = new int[target+1];
            for (int T = 0; T <= target; T++) {
                int notTake = prev[T];
                int take = 0;
                if(coins[indx] <= T) {
                    take = curr[T-coins[indx]];
                }
                curr[T] = take + notTake;
            }
            prev = curr;
        }
        return prev[target];
    }

    //Tabulation
    private static int totalWays2(int[] coins, int n, int target) {
        int[][] dp = new int[coins.length][target+1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        for(int T = 0; T <= target; T++) {
            if(T % coins[0] == 0) dp[0][T] = 1;
        }

        for (int indx = 1; indx < n; indx++) {
            for (int T = 0; T <= target; T++) {
                int notTake = dp[indx-1][T];
                int take = 0;
                if(coins[indx] <= T) {
                    take = dp[indx][T-coins[indx]];
                }
                dp[indx][T] = take + notTake;
            }
        }
        return dp[n-1][target];
    }

    //Memoization
    private static int totalWays1(int[] coins, int target) {
        int[][] dp = new int[coins.length][target+1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        return helper1(coins.length-1, coins, target, dp);
    }

    private static int helper1(int indx, int[] coins, int target, int[][] dp) {
        if(indx == 0) {
            if(target % coins[0] == 0) return 1;
        }

        if(dp[indx][target] != -1) return dp[indx][target];

        int notTake = helper1(indx-1, coins, target, dp);
        int take = 0;
        if(coins[indx] <= target) {
            take = helper1(indx, coins, target-coins[indx], dp);
        }
        return take + notTake;
    }

    //Recursion
    private static int totalWays(int[] coins, int target) {
        return helper(coins.length-1, coins, target);
    }

    private static int helper(int indx, int[] coins, int target) {
        if(indx == 0) {
            if(target % coins[0] == 0) return 1;
        }

        int notTake = helper(indx-1, coins, target);
        int take = 0;
        if(coins[indx] <= target) {
            take = helper(indx, coins, target-coins[indx]);
        }
        return take + notTake;
    }
}
