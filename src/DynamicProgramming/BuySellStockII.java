package DynamicProgramming;

public class BuySellStockII {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(buysell(prices, prices.length));
        System.out.println(buysell1(prices, prices.length));
        System.out.println(buysell2(prices, prices.length));
        System.out.println(buysell3(prices, prices.length));
    }



    //Recursion
    private static int buysell(int[] prices, int n) {
        return help(prices, n, 0, true);
    }

    private static int help(int[] prices, int n, int indx, boolean buy) {
        if(indx == n) return 0;

        int profit;
        if(buy) {
            profit = Math.max(-prices[indx] + help(prices, n, indx+1, false), 0 + help(prices, n, indx+1, true));
        }
        else {
            profit = Math.max(prices[indx] + help(prices, n, indx+1, true), 0 + help(prices, n, indx+1, false));
        }
        return profit;
    }

    // Memoization
    private static int buysell1(int[] prices, int n) {
        int[][] dp = new int[n][2];
        for (int i = 0; i < n; i++) {
            dp[i][0] = -1; // when we have stock (must sell)
            dp[i][1] = -1; // when we can buy
        }
        return help1(prices, n, 0, true, dp);
    }

    private static int help1(int[] prices, int n, int indx, boolean buy, int[][] dp) {
        if (indx == n) return 0;

        // Check memoization
        if (buy && dp[indx][1] != -1) return dp[indx][1];
        if (!buy && dp[indx][0] != -1) return dp[indx][0];

        int profit;
        if (buy) {
            // Either buy or skip
            profit = Math.max(
                    -prices[indx] + help1(prices, n, indx + 1, false, dp),
                    0 + help1(prices, n, indx + 1, true, dp)
            );
            dp[indx][1] = profit;
        } else {
            // Either sell or skip
            profit = Math.max(
                    prices[indx] + help1(prices, n, indx + 1, true, dp),
                    0 + help1(prices, n, indx + 1, false, dp)
            );
            dp[indx][0] = profit;
        }
        return profit;
    }

    //Tabulation
    private static int buysell2(int[] prices, int n) {
        int[][] dp = new int[n+1][2];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = -1; // when we have stock (must sell)
            dp[i][1] = -1; // when we can buy
        }

        dp[n][0] = dp[n][1] = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if(buy == 1) {
                    profit = Math.max(-prices[i] + dp[i+1][0], 0 + dp[i+1][1]);
                }
                else {
                    profit = Math.max(prices[i] + dp[i + 1][1], 0 + dp[i + 1][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }

    //Space Optimisation
    private static int buysell3(int[] prices, int n) {
        int[] ahead = new int[2];

        ahead[0] = 0; // when we have stock (must sell)
        ahead[1] = 0; // when we can buy

        ahead[0] = ahead[1] = 0;
        for (int i = n-1; i >= 0; i--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <= 1; buy++) {
                int profit;
                if(buy == 1) {
                    profit = Math.max(-prices[i] + ahead[0], 0 + ahead[1]);
                }
                else {
                    profit = Math.max(prices[i] + ahead[1], 0 + ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[1];
    }
}
