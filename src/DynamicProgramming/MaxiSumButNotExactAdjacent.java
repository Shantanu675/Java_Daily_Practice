package DynamicProgramming;

import java.util.Arrays;

public class MaxiSumButNotExactAdjacent {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        System.out.println(fun(arr.length, arr));
        System.out.println(fun2(arr.length, arr));
        System.out.println(fun3(arr.length, arr));
        System.out.println(fun4(arr.length, arr));
    }

    // Recursion
    public static int fun(int n, int[] arr) {
        return helper(n-1, arr);
    }

    public static int helper(int n, int[] arr){
        if(n == 0) return arr[n];
        if(n < 0) return 0;

        int pick = arr[n] + helper(n-2, arr);
        int nonPick = 0 + helper(n-1, arr);

        return Math.max(pick, nonPick);
    }

    // Memoization
    public static int fun2(int n, int[] arr){
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper2(n-1, arr, dp);
    }

    private static int helper2(int n, int[] arr, int[] dp) {
        if(n == 0) return dp[n] = arr[n];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];

        int pick = arr[n] + helper2(n-2, arr, dp);
        int nonPick = 0 + helper2(n-1, arr, dp);

        return dp[n] = Math.max(pick, nonPick);
    }

    // Tabulation
    public static int fun3(int n, int[] arr) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper3(n-1, arr, dp);
    }

    private static int helper3(int n, int[] arr, int[] dp) {
        dp[0] = arr[0];
        //int neg = 0;

        for (int i = 1; i <= n; i++) {
            int pick = arr[i];
            if(i >= 2){
                pick += dp[i-2];
            }
            int nonpick = 0 + dp[i-1];

            dp[i] = Math.max(pick, nonpick);
        }
        return dp[n];
    }

    // Space Optimization
    public static int fun4(int n, int[] arr){
        int prev = arr[0];
        int prev2 = 0;
        int curi = 0;

        for (int i = 1; i < n; i++) {
            int pick = prev2 + arr[i];
            int nonpick = prev + 0;

            curi = Math.max(pick, nonpick);

            prev2 = prev;
            prev = curi;
        }
        return curi;
    }
}
