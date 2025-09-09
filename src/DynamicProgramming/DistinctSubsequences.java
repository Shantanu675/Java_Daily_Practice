package DynamicProgramming;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println(distinctSeq(s1, s2));
        System.out.println(distinctSeq1(s1, s2));
        System.out.println(distinctSeq2(s1, s2));
        System.out.println(distinctSeq3(s1, s2));
        System.out.println(distinctSeq4(s1, s2));
    }

    //Recursion
    private static int distinctSeq(String s1, String s2) {
        return help(s1, s2, s1.length()-1, s2.length()-1);
    }

    private static int help(String s1, String s2, int i, int j) {
        if(j < 0) return 1;
        if(i < 0) return 0;

        if(s1.charAt(i) == s2.charAt(j)) {
            return (help(s1, s2, i-1, j-1) + help(s1, s2, i-1, j));
        }
        return help(s1, s2, i-1, j);
    }

    //Memoization
    private static int distinctSeq1(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return help1(s1, s2, s1.length()-1, s2.length()-1, dp);
    }

    private static int help1(String s1, String s2, int i, int j, int[][] dp) {
        if(j < 0) return 1;
        if(i < 0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = (help1(s1, s2, i-1, j-1, dp) + help1(s1, s2, i-1, j, dp));
        }
        return dp[i][j] = help1(s1, s2, i-1, j, dp);
    }

    //Tabulation
    private static int distinctSeq2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]);
                }
                else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][m];
    }

    //Space Optimisation
    private static int distinctSeq3(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for (int i = 0; i <= n; i++) {
            prev[0] = 1;
            curr[0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = (prev[j-1] + prev[j]);
                }
                else {
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return prev[m];
    }

    //2arr -> 1arr
    private static int distinctSeq4(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m+1];

        for (int i = 0; i <= n; i++) {
            prev[0] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = m; j >= 1; j--) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    prev[j] = (prev[j-1] + prev[j]);
                }
                else {
                    prev[j] = prev[j];
                }
            }
        }
        return prev[m];
    }
}
