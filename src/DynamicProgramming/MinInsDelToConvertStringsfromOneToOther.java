package DynamicProgramming;

public class MinInsDelToConvertStringsfromOneToOther {
    public static void main(String[] args) {
        String s1 = "abcd";
        String s2 = "anc";

        System.out.println(converStrings(s1, s2));
    }

    private static int converStrings(String s1, String s2) {
        int n = lcs(s1, s2);

        return (s1.length() + s2.length() - 2*n);
    }

    //Space Optimisation
    private static int lcs(String s1, String s2) {
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
}
