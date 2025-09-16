package DynamicProgramming;

public class BuySellStockV {
    public static void main(String[] args) {
        int[] prices = {1,7,9,8,2};
        System.out.println(maxProfit(prices, prices.length));
    }

    //Tabulation
    private static int maxProfit(int[] prices, int n) {
        int[][] dp = new int[n+2][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1; // when we have stock (must sell)
            dp[i][1] = -1; // when we can buy
        }

        dp[n][0] = dp[n][1] = 0;
        for (int i = n-1; i >= 0; i--) {
            dp[i][1] = Math.max(-prices[i] + dp[i+1][0], dp[i+1][1]);

            dp[i][0] = Math.max(prices[i] + dp[i+2][1], dp[i + 1][0]);
        }
        return dp[0][1];
    }
}
