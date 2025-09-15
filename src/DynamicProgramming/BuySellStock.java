package DynamicProgramming;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        System.out.println(buy_sell(prices));
    }

    private static int buy_sell(int[] prices) {
        int profit = 0;
        int mini = prices[0];

        for (int i = 0; i < prices.length; i++) {
            int cost = prices[i] - mini;
            profit = Math.max(profit, cost);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }
}
