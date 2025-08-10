package DynamicProgramming;

import java.util.Arrays;

public class Fibonnaci {

    public static void main(String[] args) {
        int n = 8;
        System.out.println(fibo(n));
        System.out.println(fiboMemoization(n));
        System.out.println(fiboTabulation(n));
        System.out.println(fiboSudoTabulation(n));
    }

    //------------------------------------------------------
    // Recurssion   # TC - O(2^n)  # SC - O(n)+O(n)
    public static int fibo(int n){
        if(n < 2){
            return n;
        }
        return fibo(n-1) + fibo(n-2);
    }

    //-----------------------------------------------------------
    // Memoization # TC - O(n)  # SC - O(n)
    public static int fiboMemoization(int n){
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }

    public static int helper(int n, int[] dp){
        if(n < 2){
            return n;
        }

        if(dp[n] != -1) return dp[n];
        return dp[n] = helper(n-1, dp) + helper(n-2, dp);
    }

    //---------------------------------------------------------
    // Tabulation  # TC - O(n)  # SC - O(n)
    public static int fiboTabulation(int n){
        int[] dp = new int[n+1];
        //Arrays.fill(dp, -1);
        return helper1(n, dp);
    }

    public static int helper1(int n, int[] dp){
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //--------------------------------------------------------------
    // SudoTabulation  # TC - O(n)  # SC - O(1)
    public static int fiboSudoTabulation(int n){
        int prev1 = 0;
        int prev2 = 1;
        int curr = 0;

        for (int i = 2; i <= n; i++) {
            curr = prev1 + prev2;
            prev1 = prev2;
            prev2 = curr;
        }
        return curr;
    }
}
