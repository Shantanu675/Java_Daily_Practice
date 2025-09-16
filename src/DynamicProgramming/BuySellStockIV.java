package DynamicProgramming;

public class BuySellStockIV {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 5, 0, 0, 3, 1, 4};

        System.out.println(maxprofit(prices, 3));
        System.out.println(maxprofit1(prices, 3));
        System.out.println(maxprofit2(prices, 3));
        System.out.println(maxprofit3(prices, 3));
    }

    // Recursion
    private static int maxprofit(int[] prices, int k) {
        return helper(prices, 0, k, 0, prices.length);
    }

    private static int helper(int[] prices, int tarns, int k, int indx, int n) {
        if(indx == n || tarns == 2*k) return 0;

        if(tarns % 2 == 0) {
            return Math.max(-prices[indx] + helper(prices, tarns+1, k, indx+1, n),
                    helper(prices, tarns, k, indx+1, n));
        }
        return Math.max(prices[indx] + helper(prices, tarns+1, k, indx+1, n),
                helper(prices, tarns, k, indx+1, n));
    }

    // Memoization
    private static int maxprofit1(int[] prices, int k) {
        int n = prices.length;
        int[][] dp = new int[n][2*k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*k; j++) {
                dp[i][j] = -1;
            }
        }
        return helper1(prices, 0, k, 0, n, dp);
    }

    private static int helper1(int[] prices, int tarns, int k, int indx, int n, int[][] dp) {
        if(indx == n || tarns == 2*k) return 0;
        if(dp[indx][tarns] != -1) return dp[indx][tarns];

        if(tarns % 2 == 0) {
            return dp[indx][tarns] = Math.max(-prices[indx] + helper1(prices, tarns+1, k, indx+1, n, dp),
                    helper1(prices, tarns, k, indx+1, n, dp));
        }
        return dp[indx][tarns] = Math.max(prices[indx] + helper1(prices, tarns+1, k, indx+1, n, dp),
                helper1(prices, tarns, k, indx+1, n, dp));
    }

    // Tabulation
    private static int maxprofit2(int[] prices, int k) {
        int n = prices.length;
        int[][] dp = new int[n+1][2*k+1];

        for (int indx = n-1; indx >= 0; indx--) {
            for (int trans = 2*k-1; trans >= 0; trans--) {
                if(trans % 2 == 0) {
                    dp[indx][trans] = Math.max(-prices[indx] + dp[indx+1][trans+1],
                            dp[indx+1][trans]);
                }
                else {
                    dp[indx][trans] = Math.max(prices[indx] + dp[indx+1][trans+1],
                            dp[indx+1][trans]);
                }
            }
        }
        return dp[0][0];
    }

    // Space Optimisation
    private static int maxprofit3(int[] prices, int k) {
        int n = prices.length;
        int[] prev = new int[2*k+1];

        for (int indx = n-1; indx >= 0; indx--) {
            int[] curr = new int[2*k+1];
            for (int trans = 2*k-1; trans >= 0; trans--) {
                if(trans % 2 == 0) {
                    curr[trans] = Math.max(-prices[indx] + prev[trans+1],
                            prev[trans]);
                }
                else {
                    curr[trans] = Math.max(prices[indx] + prev[trans+1],
                            prev[trans]);
                }
            }
            prev = curr;
        }
        return prev[0];
    }

}
