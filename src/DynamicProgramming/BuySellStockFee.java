package DynamicProgramming;

public class BuySellStockFee {
    public static void main(String[] args) {
        int[] prices = {1, 3, 5, 8, 4, 9};
        System.out.println(maxPro(prices.length, 2, prices));
    }

    private static int maxPro(int n, int fee, int[] prices) {
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
                    profit = Math.max(prices[i] - fee + ahead[1], 0 + ahead[0]);
                }
                curr[buy] = profit;
            }
            ahead = curr;
        }
        return ahead[1];
    }
}
