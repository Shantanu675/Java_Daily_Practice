package DynamicProgramming;

import OOP.Intro;

import java.util.Arrays;

public class FrogJump {
    public static void main(String[] args) {
        int[] arr = {30, 10, 60, 10, 60, 50};
        System.out.println(jumpFrog(arr));
        System.out.println(jumpFrog1(arr));
        System.out.println(jumpFrog2(arr));
        System.out.println(jumpFrog3(arr));
    }

    // Recursion
    private static int jumpFrog(int[] arr) {
        int n = arr.length;
        return jump(arr, n-1);
    }

    private static int jump(int[] arr, int n) {
        if(n == 0) return 0;

        int left = jump(arr, n-1) + Math.abs(arr[n] - arr[n-1]);
        int right = Integer.MAX_VALUE;
        if(n > 1){
            right = jump(arr, n-2) + Math.abs(arr[n] - arr[n-2]);
        }
        return Math.min(left, right);
    }

    // memoization
    private static int jumpFrog1(int[] arr) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return jump1(dp, arr, n-1);
    }

    private static int jump1(int[] dp, int[] arr, int n) {
        if(n == 0) return 0;

        if(dp[n] == -1) {
            int left = jump(arr, n - 1) + Math.abs(arr[n] - arr[n - 1]);
            int right = Integer.MAX_VALUE;
            if (n > 1) {
                right = jump(arr, n - 2) + Math.abs(arr[n] - arr[n - 2]);
            }
            return dp[n] = Math.min(left, right);
        }
        return dp[n];
    }

    // tabulation
    private static int jumpFrog2(int[] arr) {
        int[] dp = new int[arr.length];
        int n = arr.length;
        dp[0] = 0;

        for(int i = 1; i < n; i++) {
            int left = dp[i - 1] + Math.abs(arr[i] - arr[i - 1]);
            int right = Integer.MAX_VALUE;
            if (i > 1) {
                right = dp[i - 2] + Math.abs(arr[i] - arr[i - 2]);
            }
            dp[i] = Math.min(left, right);
        }
        return dp[n-1];
    }

    // sudo-tabulation
    private static int jumpFrog3(int[] arr) {
        int n = arr.length;
        int prev1 = 0;
        int prev2 = 0;
        for(int i = 1 ; i < n; i++){
            int left = prev1 + Math.abs(arr[i] - arr[i-1]);
            int right = Integer.MAX_VALUE;
            if(i > 1) {
                right = prev2 + Math.abs(arr[i] - arr[i-2]);
            }
            int curr = Math.min(left, right);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
}