package DynamicProgramming;

public class RodCuttingInfiniteSupply {
    public static void main(String[] args) {
        int[] price = {2, 5, 7, 8, 10};
        int n = 5;
        System.out.println(maximPrice(price, n));
        System.out.println(maximPrice1(price, n));
        System.out.println(maximPrice2(price, n));
        System.out.println(maximPrice3(price, n));
        System.out.println(maximPrice4(price, n));
    }

    //2Arr -> 1Arr
    private static int maximPrice4(int[] price, int n) {
        int[] prev = new int[n+1];

        for (int N = 0; N <= n; N++) {
            prev[N] = N * price[0];
        }

        for (int indx = 1; indx < price.length; indx++) {
            for (int N = 0; N <= n; N++) {
                int notTake = prev[N];
                int take = Integer.MIN_VALUE;
                int rodLen = indx + 1;
                if(rodLen <= N) {
                    take = price[indx] + prev[N - rodLen];
                }

                prev[N] = Math.max(take, notTake);
            }
        }
        return prev[n];
    }

    //Space Optimisation
    private static int maximPrice3(int[] price, int n) {
        int[] prev = new int[n+1];

        for (int N = 0; N <= n; N++) {
            prev[N] = N * price[0];
        }

        for (int indx = 1; indx < price.length; indx++) {
            int[] curr = new int[n+1];
            for (int N = 0; N <= n; N++) {
                int notTake = prev[N];
                int take = Integer.MIN_VALUE;
                int rodLen = indx + 1;
                if(rodLen <= N) {
                    take = price[indx] + curr[N - rodLen];
                }

                curr[N] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[n];
    }

    //Tabulation
    private static int maximPrice2(int[] price, int n) {
        int[][] dp = new int[price.length][n+1];
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        for (int N = 0; N <= n; N++) {
            dp[0][N] = N * price[0];
        }

        for (int indx = 1; indx < price.length; indx++) {
            for (int N = 0; N <= n; N++) {
                int notTake = dp[indx-1][N];
                int take = Integer.MIN_VALUE;
                int rodLen = indx + 1;
                if(rodLen <= N) {
                    take = price[indx] + dp[indx][N - rodLen];
                }

                dp[indx][N] = Math.max(take, notTake);
            }
        }
        return dp[price.length-1][n];
    }

    //Memoization
    private static int maximPrice1(int[] price, int n) {
        int[][] dp = new int[price.length][n+1];
        for (int i = 0; i < price.length; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        return helper1(price, price.length-1, n, dp); // here n is sum of number of partition
    }

    private static int helper1(int[] price, int indx, int N, int[][] dp) {
        if(indx == 0) {
            return N * price[0];
        }

        if(dp[indx][N] != -1) return dp[indx][N];

        int notTake = 0 + helper1(price, indx-1, N, dp);
        int take = Integer.MIN_VALUE;
        int rodLen = indx + 1;
        if(rodLen <= N) {
            take = price[indx] + helper1(price, indx, N - rodLen, dp);
        }

        return dp[indx][N] = Math.max(take, notTake);
    }

    //Recursion
    private static int maximPrice(int[] price, int n) {
        return helper(price, price.length-1, n); // here n is sum of number of partition
    }

    private static int helper(int[] price, int indx, int N) {
        if(indx == 0) {
            return N * price[0];
        }

        int notTake = 0 + helper(price, indx-1, N);
        int take = Integer.MIN_VALUE;
        int rodLen = indx + 1;
        if(rodLen <= N) {
            take = price[indx] + helper(price, indx, N - rodLen);
        }

        return Math.max(take, notTake);
    }
}
