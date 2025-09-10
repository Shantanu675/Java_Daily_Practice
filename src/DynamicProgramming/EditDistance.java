package DynamicProgramming;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println(editDis(s1, s2));
        System.out.println(editDis1(s1, s2));
        System.out.println(editDis2(s1, s2));
        System.out.println(editDis3(s1, s2));
    }

    //Recursion
    private static int editDis(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        return helper(n-1, m-1, s1, s2);
    }

    private static int helper(int i, int j, String s1, String s2) {
        if(i == -1) return j+1;
        if(j == -1) return i+1;

        if(s1.charAt(i) == s2.charAt(j)) return helper(i-1, j-1, s1, s2);

        return 1 + Math.min(helper(i-1, j, s1, s2), Math.min(helper(i, j-1, s1, s2), helper(i-1, j-1, s1, s2)));
    }

    //Memoization
    private static int editDis1(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return helper1(n-1, m-1, s1, s2, dp);
    }

    private static int helper1(int i, int j, String s1, String s2, int[][] dp) {
        if(i == -1) return j+1;
        if(j == -1) return i+1;
        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)) return dp[i][j] = helper1(i-1, j-1, s1, s2, dp);

        return dp[i][j] = 1 + Math.min(helper1(i-1, j, s1, s2, dp), Math.min(helper1(i, j-1, s1, s2, dp), helper1(i-1, j-1, s1, s2, dp)));
    }

    //Tabulation
    private static int editDis2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = 0;
            }
        }

        for (int i = 0; i <= m; i++) dp[i][0] = i;
        for (int j = 0; j <= m; j++) dp[0][j] = j;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                else {
                    dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }
        return dp[n][m];
    }

    //Space Optimisation
    private static int editDis3(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[] prev = new int[m+1];

        for (int j = 0; j <= m; j++) prev[j] = j;

        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m+1];
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = prev[j-1];
                }
                else {
                    curr[j] = 1 + Math.min(prev[j], Math.min(curr[j-1], prev[j-1]));
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}
