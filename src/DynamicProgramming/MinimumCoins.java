package DynamicProgramming;

public class MinimumCoins {
    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int target = 7;
        System.out.println(minCoins(coins.length, coins, target));
        System.out.println(minCoins1(coins.length, coins, target));
        System.out.println(minCoins2(coins.length, coins, target));
        System.out.println(minCoins3(coins.length, coins, target));
    }

    //Space Optimisation
    private static int minCoins3(int n, int[] coins, int target) {
        int[] prev = new int[target+1];

        for (int T = 0; T <= target; T++) {
            if(T % coins[0] == 0) prev[T] = T/coins[0];
            else prev[T] = (int)1e9;
        }

        for (int i = 1; i < n; i++) {
            int[] curr = new int[target+1];
            for (int j = 1; j <= target; j++) {
                int notTake = prev[j];
                int take = (int)1e9;
                if(coins[i] <= j) {
                    take = 1 + curr[j-coins[i]];
                }

                curr[j] = Math.min(take, notTake);
            }
            prev = curr;
        }

        int ans = prev[target];
        if(ans > (int)1e9) return -1;
        return ans;
    }

    //Tabulation
    private static int minCoins2(int n, int[] coins, int target) {
        int[][] dp = new int[n][target+1];

        for (int T = 0; T <= target; T++) {
            if(T % coins[0] == 0) dp[0][T] = T/coins[0];
            else dp[0][T] = (int)1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                int notTake = dp[i-1][j];
                int take = (int)1e9;
                if(coins[i] <= j) {
                    take = 1 + dp[i][j-coins[i]];
                }

                dp[i][j] = Math.min(take, notTake);
            }
        }

        int ans = dp[n-1][target];
        if(ans > (int)1e9) return -1;
        return ans;
    }

    //Memoization
    private static int minCoins1(int n, int[] coins, int target) {
        int[][] dp = new int[n][target+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = helper1(n-1, coins, target, dp);
        if(ans > (int)1e9) return -1;
        else return ans;
    }

    private static int helper1(int indx, int[] coins, int target, int[][] dp) {
        if(indx == 0){
            if(target % coins[0] == 0) return target / coins[0];
            else return (int)1e9;
        }
        if(dp[indx][target] != -1) return dp[indx][target];

        int notTake = helper1(indx-1, coins, target, dp);
        int take = (int)1e9;
        if(coins[indx] <= target) {
            take = 1 + helper1(indx, coins, target-coins[indx], dp);
        }

        return dp[indx][target] = Math.min(take, notTake);
    }

    //Recursion
    private static int minCoins(int n, int[] coins, int target) {
        int ans = helper(n-1, coins, target);
        if(ans > (int)1e9) return -1;
        return ans;
    }

    private static int helper(int indx, int[] coins, int target) {
        if(indx == 0) {
            if(target % coins[0] == 0) return target/coins[0];
            else return (int)1e9;
        }

        int notTake = helper(indx - 1, coins, target);
        int take = (int)1e9;
        if(coins[indx] <= target) {
            take = 1 + helper(indx, coins, target - coins[indx]);
        }

        return Math.min(take, notTake);
    }
}
