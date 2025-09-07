package DynamicProgramming;

public class LongestCommonSubsequences {
    public static void main(String[] args) {
        String s1 = "adcbc";
        String s2 = "dcadb";

        System.out.println(lcs(s1, s2));
        System.out.println(lcs1(s1, s2));
        System.out.println(lcs2(s1, s2));
        System.out.println(lcs3(s1, s2));
    }

    //Space Optimisation
    private static int lcs3(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[] prev = new int[n1+1];

        for (int i = 0; i <= n1; i++) prev[i] = 0;

        for (int i = 1; i <= n1; i++) {
            int[] curr = new int[n2+1];
            for (int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                }
                else {
                    curr[j] = Math.max(prev[j], curr[j-1]);
                }
            }
            prev = curr;
        }
        return prev[n2];
    }

    //Tabulation
    private static int lcs2(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 0; i <= n1; i++) dp[i][0] = 0;
        for (int j = 0; j <= n2; j++) dp[0][j] = 0;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n1][n2];
    }

    //Memoization
    private static int lcs1(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1][n2];

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                dp[i][j] = -1;
            }
        }

        return helper1(n1-1, n2-1, s1, s2, dp);
    }

    private static int helper1(int indx1, int indx2, String s1, String s2, int[][] dp) {
        if(indx1 < 0 || indx2 < 0) {
            return 0;
        }

        if(dp[indx1][indx2] != -1) return dp[indx1][indx2];

        if(s1.charAt(indx1) == s2.charAt(indx2)) {
            return dp[indx1][indx2] = 1 + helper1(indx1-1, indx2-1, s1, s2, dp);
        }
        return dp[indx1][indx2] = Math.max(helper1(indx1-1, indx2, s1, s2, dp), helper1(indx1, indx2-1, s1, s2, dp));
    }

    //Recursion
    private static int lcs(String s1, String s2) {
        int n1 = s1.length() - 1;
        int n2 = s2.length() - 1;

        return helper(n1, n2, s1, s2);
    }

    private static int helper(int indx1, int indx2, String s1, String s2) {
        if(indx1 < 0 || indx2 < 0) {
            return 0;
        }

        if(s1.charAt(indx1) == s2.charAt(indx2)) {
            return 1 + helper(indx1-1, indx2-1, s1, s2);
        }
        return Math.max(helper(indx1-1, indx2, s1, s2), helper(indx1, indx2-1, s1, s2));
    }
}
