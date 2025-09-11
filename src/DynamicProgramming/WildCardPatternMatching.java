package DynamicProgramming;

public class WildCardPatternMatching {
    public static void main(String[] args) {
        String s1 = "ab*cd";
        String s2 = "abdefcd";

        System.out.println(wildCard(s1, s2));
        System.out.println(wildCard1(s1, s2));
        System.out.println(wildCard2(s1, s2));
    }

    //Recursion
    private static boolean wildCard(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        return helper(n-1, m-1, s1, s2);
    }

    private static boolean helper(int i, int j, String s1, String s2) {
        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(j < 0 && i >= 0) {
            for (int k = 0; k < i; k++) {
                if(s1.charAt(i) == '*') return false;
            }
            return true;
        }

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return helper(i-1, j-1, s1, s2);
        }
        if(s1.charAt(i) == '*') {
            return helper(i-1, j, s1, s2) || helper(i, j-1, s1, s2);
        }
        return false;
    }

    //Memoization
    private static boolean wildCard1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        boolean[][] dp = new boolean[n][m];
        return helper1(n-1, m-1, s1, s2, dp);
    }

    private static boolean helper1(int i, int j, String s1, String s2, boolean[][] dp) {
        if(i < 0 && j < 0) return true;
        if(i < 0 && j >= 0) return false;
        if(j < 0 && i >= 0) {
            for (int k = 0; k <= i; k++) {
                if(s1.charAt(i) == '*') return false;
            }
            return true;
        }

        if(dp[i][j]) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j) || s1.charAt(i) == '?') {
            return dp[i][j] = helper1(i-1, j-1, s1, s2, dp);
        }
        if(s1.charAt(i) == '*') {
            return dp[i][j] = helper1(i-1, j, s1, s2, dp) || helper1(i, j-1, s1, s2, dp);
        }
        return dp[i][j] = false;
    }

    //Tabulation
    private static boolean wildCard2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        boolean[][] dp = new boolean[n+1][m+1];
        dp[0][0] = true;
        for (int j = 1; j <= m; j++) {
            dp[0][j] = false;
        }

        for (int i = 1; i <= n; i++) {
            boolean flag = true;
            for (int j = 1; j <= i; j++) {
                if(s1.charAt(j-1) == '*') {
                    flag = false;
                    break;
                }
            }
            dp[i][0] = flag;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1) || s1.charAt(i-1) == '?') {
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(s1.charAt(i-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
                else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }
}
