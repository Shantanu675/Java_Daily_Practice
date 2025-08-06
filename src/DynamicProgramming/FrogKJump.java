package DynamicProgramming;

import java.util.Arrays;

public class FrogKJump {
    public static void main(String[] args) {
        int[] arr = {30, 10, 60, 10, 60, 50};
        int k = 3;
        System.out.println(jumpKFrog(arr, k));
        System.out.println(jumpKFrog1(arr, k));
        System.out.println(jumpKFrog2(arr, k));
    }

    //
    private static int jumpKFrog2(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return jumpK2(dp, arr, k, n-1);
    }

    private static int jumpK2(int[] dp, int[] arr, int k, int n) {
        int[] prev = new int[k+1];
        prev[0] = 0;

        for (int i = 1; i < n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int prevIndex = (i - j) % (k + 1);
                    int jump = prev[prevIndex] + Math.abs(arr[i] - arr[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            prev[i % (k + 1)] = minSteps;
        }

        return prev[(n - 1) % (k + 1)];
    }

    // tabulation TC- O(n*k) SC-O(N)
    private static int jumpKFrog1(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return jumpK1(dp, arr, k, n-1);
    }

    private static int jumpK1(int[] dp, int[] arr, int k, int n) {
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            int minSteps = Integer.MAX_VALUE;
            for (int j = 1; j <= k; j++) {
                if (i - j >= 0) {
                    int jump = dp[i - j] + Math.abs(arr[i] - arr[i - j]);
                    minSteps = Math.min(minSteps, jump);
                }
            }
            dp[i] = minSteps;
        }
        return dp[n];
    }

    //Recursion
    private static int jumpKFrog(int[] arr, int k) {
        int n = arr.length;
        return jumpK(arr, k, n-1);
    }

    private static int jumpK(int[] arr, int k, int n) {
        if(n == 0) {
            return 0;
        }

        int minStep = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++){
            if(n-j >= 0) {
                int jump = jumpK(arr, k, n - j) + Math.abs(arr[n] - arr[n - j]);
                minStep = Math.min(minStep, jump);
            }
        }
        return minStep;
    }

    //
}
