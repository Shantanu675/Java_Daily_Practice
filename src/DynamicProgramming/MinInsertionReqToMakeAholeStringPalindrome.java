package DynamicProgramming;

public class MinInsertionReqToMakeAholeStringPalindrome {
    public static void main(String[] args) {
        String s = "abcaa";
        System.out.println(minInsertion(s));
    }

    private static int minInsertion(String s) {
        String s1 = s;
        char[] arr = s.toCharArray();

        int ptr1 = 0;
        int ptr2 = arr.length - 1;

        while (ptr1 < ptr2) {
            char temp = arr[ptr1];
            arr[ptr1] = arr[ptr2];
            arr[ptr2] = temp;

            ptr1++;
            ptr2--;
        }
        String s2 = new String(arr);
        int i = lengthOfMaxPalindrome(s1, s2);
        return s.length() - i;
    }

    private static int lengthOfMaxPalindrome(String s1, String s2) {
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
        StringBuilder ans = new StringBuilder();

        int i = n1, j = n2;

        while (i > 0 && j > 0) {
            if (s1.charAt(i-1) == s2.charAt(j-1)) {
                ans.insert(0, s1.charAt(i - 1));
                i--; j--;
            }
            else if (dp[i-1][j] > dp[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }
        return ans.length();
    }
}
