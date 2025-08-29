package DynamicProgramming;

import java.util.Arrays;

public class SubsequenceSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 2};
        System.out.println(isSubSeqAvail(arr, 4));
        System.out.println(isSubSeqAvail1(arr, 4));
        //System.out.println(isSubSeqAvail2(arr, 4));
    }

    //Recursion
    private static boolean isSubSeqAvail(int[] arr, int target) {
        return helper(arr.length-1, arr, target);
    }

    private static boolean helper(int indx, int[] arr, int target) {
        if(target == 0) return true;
        if(indx == 0) return target == arr[0];

        boolean notTaken = helper(indx-1, arr, target);
        boolean taken = false;
        if(target >= arr[indx]) {
            taken = helper(indx-1, arr, target - arr[indx]);
        }
        return notTaken || taken;
    }

    // Memoization
    private static boolean isSubSeqAvail1(int[] arr, int target) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);

        return helper1(arr.length-1, arr, target, dp);
    }

    private static boolean helper1(int indx, int[] arr, int target, int[] dp) {
        if(target == 0) return true;
        if(indx == 0) return target == arr[0];
        if(dp[indx] != -1) return dp[indx] == 1;

        boolean notTaken = helper1(indx-1, arr, target, dp);
        boolean taken = false;
        if(target >= arr[indx]) {
            taken = helper1(indx-1, arr, target - arr[indx], dp);
        }

        dp[indx] = (notTaken || taken) == true ? 1 :  0;

        return (notTaken || taken);
    }

    // Tabulation
//    private static boolean isSubSeqAvail2(int[] arr, int target) {
//        return helper2(arr.length, arr, target);
//    }

//    private static boolean helper2(int n, int[] arr, int target) {
//        boolean[][] dp = new boolean[n][target];
//
//        for (int i = 0; i < n; i++) dp[i][0] = true;
//        if(arr[0] <= target) dp[0][arr[0]] = true;
//
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j <= target; j++) {
//                boolean notTaken = dp[i-1][j];
//                boolean taken = false;
//                if(target >= arr[i]) {
//                    taken = dp[i-1][j-arr[i]];
//                }
//                dp[i][j] = taken || notTaken;
//            }
//        }
//        return dp[n-1][target];
//    }
}
