package DynamicProgramming;

public class SubSeqSumInArr {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        System.out.println(subSeq(arr, arr.length-1, 3));
        System.out.println(subSeq1(arr, arr.length, 3));
        System.out.println(subSeq2(arr, arr.length, 3));
        System.out.println(subSeq3(arr, arr.length, 3));
    }

    //Space Optimisation
    private static int subSeq3(int[] arr, int n, int k) {
        int[] prev = new int[k+1];

        prev[0] = 1;

        if(arr[0] <= k) prev[arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            int[] curr = new int[k+1];
            curr[0] = 1;
            for (int j = 1; j <= k; j++) {
                int notPick = prev[j];
                int pick = 0;
                if(arr[i] <= j) {
                    pick = prev[j-arr[i]];
                }

                curr[j] = notPick + pick;
            }
            prev = curr;
        }
        return prev[k];
    }

    //Tabulation
    private static int subSeq2(int[] arr, int n, int target) {
        int[][] dp = new int[n][target+1];

        for (int i = 0; i < n; i++) dp[i][0] = 1;

        if(arr[0] <= target) dp[0][arr[0]] = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= target; j++) {
                int notPick = dp[i-1][j];
                int pick = 0;
                if(arr[i] <= j) {
                    pick = dp[i-1][j-arr[i]];
                }

                dp[i][j] = notPick + pick;
            }
        }
        return dp[n-1][target];
    }

    //Memoization
    private static int subSeq1(int[] arr, int n, int target) {
        int[][] dp = new int[n][target+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = -1;
            }
        }
        return helper(arr, n-1, target, dp);
    }

    private static int helper(int[] arr, int indx, int target, int[][] dp) {
        if(target == 0) return 1;
        if(indx == 0) {
            if(arr[indx] == target) return 1;
            return 0;
        }
        if(dp[indx][target] != -1) return dp[indx][target];

        int notPick = helper(arr, indx-1, target, dp);
        int pick = 0;
        if(arr[indx] <= target) {
            pick = helper(arr, indx-1, target-arr[indx], dp);
        }

        return dp[indx][target] = notPick + pick;
    }

    //Recursion
    private static int subSeq(int[] arr, int indx, int target) {
        if(target == 0) {
            return 1;
        }

        if(indx == 0) {
            if(arr[indx] == target) return 1;
            return 0;
        }

        int notPick = subSeq(arr, indx-1, target);
        int pick = 0;
        if(arr[indx] <= target) {
            pick = subSeq(arr, indx-1, target-arr[indx]);
        }

        return notPick + pick;
    }
}
