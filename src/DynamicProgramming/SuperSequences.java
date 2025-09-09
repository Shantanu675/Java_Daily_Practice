package DynamicProgramming;

public class SuperSequences {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        System.out.println(superSeq(s1, s2));
    }

    private static String superSeq(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] dp = new int[n1+1][n2+1];
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

        String ans = "";

        int i = n1, j = n2;

        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                ans = s1.charAt(i-1) + ans;
                i--; j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) {
                ans = s1.charAt(i-1) + ans;
                i--;
            }
            else {
                ans = s2.charAt(j-1) + ans;
                j--;
            }
        }

        while(i > 0) {
            ans = s1.charAt(i-1) + ans;
            i--;
        }

        while(j > 0) {
            ans = s2.charAt(j-1) + ans;
            j--;
        }
        return ans;
    }
}
