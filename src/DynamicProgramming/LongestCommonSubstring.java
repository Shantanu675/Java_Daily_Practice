package DynamicProgramming;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "abzd";

        System.out.println(lowestSubstring(s1, s2));
        System.out.println(lowestSubstring1(s1, s2));
    }

    //Space Optimation
    private static int lowestSubstring1(String s1, String s2) {
        int ans = 0;

        int n1 = s1.length();
        int n2 = s2.length();
        int[] prev = new int[n2+1];

        for (int i = 0; i <= n1; i++) prev[i] = 0;

        for (int i = 1; i <= n1; i++) {
            int[] curr = new int[n2+1];
            for (int j = 1; j <= n2; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    curr[j] = 1 + prev[j-1];
                    ans = Math.max(ans, curr[j]);
                }
                else {
                    curr[j] = 0;
                }
            }
            prev = curr;
        }
        return ans;
    }

    //Tabulation
    private static int lowestSubstring(String s1, String s2) {
        int ans = 0;

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
                    ans = Math.max(ans, dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
}
