package DynamicProgramming;

public class BuySellStockIII {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 5, 0, 0, 3, 1, 4};

        System.out.println(makeProfit(prices));
        System.out.println(makeProfit1(prices));
        System.out.println(makeProfit2(prices));
        System.out.println(makeProfit3(prices));
    }

    //Recursion
    private static int makeProfit(int[] prices) {
        int n = prices.length;
        return helper(prices, n, 0, 1, 2);
    }

    private static int helper(int[] prices, int n, int indx, int buy, int cap) {
        if(indx == n || cap == 0) return 0;

        if(buy == 1) {
            return Math.max(-prices[indx] + helper(prices, n, indx+1, 0, cap),
                    helper(prices, n, indx+1, 1, cap));
        }
        return Math.max(prices[indx] + helper(prices, n, indx+1, 1, cap-1),
                helper(prices, n, indx+1, 0, cap-1));
    }

    //Memoization
    private static int makeProfit1(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return helper1(prices, n, 0, 1, 2, dp);
    }

    private static int helper1(int[] prices, int n, int indx, int buy, int cap, int[][][] dp) {
        if(indx == n || cap == 0) return 0;
        if(dp[indx][buy][cap] != -1) return dp[indx][buy][cap];

        if(buy == 1) {
            return dp[indx][buy][cap] = Math.max(-prices[indx] + helper(prices, n, indx+1, 0, cap),
                    helper(prices, n, indx+1, 1, cap));
        }
        return dp[indx][buy][cap] = Math.max(prices[indx] + helper(prices, n, indx+1, 1, cap-1),
                helper(prices, n, indx+1, 0, cap));
    }

    //Tabulation
    private static int makeProfit2(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for (int i = 0; i < n; i++) {
            for (int buy = 0; buy < 2; buy++) {
                dp[i][buy][0] = 0;
            }
        }

        for (int buy = 0; buy < 2; buy++) {
            for (int cap = 0; cap < 2; cap++) {
                dp[n][buy][cap] = 0;
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if(buy == 1) {
                        dp[i][buy][cap] = Math.max(-prices[i] + dp[i+1][0][cap],
                                dp[i+1][1][cap]);
                    }
                    else {
                        dp[i][buy][cap] = Math.max(prices[i] + dp[i+1][1][cap-1],
                                dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }

    //Space Optimisation
    private static int makeProfit3(int[] prices) {
        int n = prices.length;
        int[][] after = new int[2][3];

//        for (int i = 0; i < n; i++) {
//            for (int buy = 0; buy < 2; buy++) {
//                dp[i][buy][0] = 0;
//            }
//        }
//
//        for (int buy = 0; buy < 2; buy++) {
//            for (int cap = 0; cap < 2; cap++) {
//                dp[n][buy][cap] = 0;
//            }
//        }

        for (int i = n-1; i >= 0; i--) {
            int[][] curr = new int[2][3];
            for (int buy = 0; buy < 2; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    if(buy == 1) {
                        curr[buy][cap] = Math.max(-prices[i] + after[0][cap],
                                after[1][cap]);
                    }
                    else {
                        curr[buy][cap] = Math.max(prices[i] + after[1][cap-1],
                                after[0][cap]);
                    }
                }
            }
            after = curr;
        }
        return after[1][2];
    }
}
