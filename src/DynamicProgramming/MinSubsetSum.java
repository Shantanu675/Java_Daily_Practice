package DynamicProgramming;

public class MinSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        System.out.println(minSubsetSumDiff(arr, 4));
    }

    private static int minSubsetSumDiff(int[] arr, int n) {
        int totSum = 0;
        for (int i = 0; i < n; i++) {
            totSum += arr[i];
        }
        int k = totSum;
        boolean[][] dp = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if(arr[0] <= k) dp[0][arr[0]] = true;

        for (int i = 1; i < n; i++) {
            for (int target = 1; target <= k; target++) {
                boolean notTaken = dp[i-1][target];
                boolean taken = false;
                if(arr[i] <= target) taken = dp[i-1][target-arr[i]];
                dp[i][target] = taken || notTaken;
            }
        }

        int mini = (int)1e9;
        for (int s1 = 0; s1 < totSum/2; s1++) {
            if(dp[n-1][s1] == true) {
                mini = Math.min(mini, Math.min(s1, totSum-s1));
            }
        }
        return mini;
    }
}
