package DynamicProgramming;

public class VariableStartEndMaxPath {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 4, 10}, {100, 3, 2, 1}, {1, 1, 20, 2}, {1, 2, 2, 1}};
        System.out.println(maxPath(arr, arr.length));
        System.out.println(maxPath1(arr));
        System.out.println(maxPath2(arr));
        System.out.println(maxPath3(arr));
    }

    // Recursion
    public static int maxPath(int[][] arr, int n) {
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++) {
             maxi = Math.max(helps(n-1, i, arr), maxi);
        }
        return maxi;
    }

    public static int helps(int i, int j, int[][] arr) {
        if(j < 0 || j >= arr[0].length) return (int)(-1e9);
        if(i == 0) return arr[i][j];

        int up = arr[i][j] + helps(i-1, j, arr);
        int diagLeft = arr[i][j] + helps(i-1, j-1, arr);
        int diagRight = arr[i][j] + helps(i-1, j+1, arr);

        return Math.max(up, Math.max(diagLeft, diagRight));
    }

    // Memoization
    public static int maxPath1(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr[0].length ; i++) {
            maxi = Math.max(helps1(arr[0].length-1, i, arr, dp), maxi);
        }
        return maxi;
    }

    public static int helps1(int i, int j, int[][] arr, int[][] dp) {
        if(j < 0 || j >= arr[0].length) return (int)(-1e9);
        if(i == 0) return arr[i][j];

        if(dp[i][j] != -1) return dp[i][j];

        int up = arr[i][j] + helps(i-1, j, arr);
        int diagLeft = arr[i][j] + helps(i-1, j-1, arr);
        int diagRight = arr[i][j] + helps(i-1, j+1, arr);

        return dp[i][j] = Math.max(up, Math.max(diagLeft, diagRight));
    }

    // Tabulation
    public static int maxPath2(int[][] arr) {
        int[][] dp = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return helps2(arr, dp);
    }

    public static int helps2(int[][] arr, int[][] dp) {
        for (int i = 0; i < arr[0].length; i++) {
            dp[0][i] = arr[0][i];
        }

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int leftDia = (int)(-1e9), rightDia = (int)(-1e9);

                int up = arr[i][j] + dp[i-1][j];
                if(j-1 >= 0) leftDia = arr[i][j] + dp[i-1][j-1];
                if(j+1 < arr[0].length) rightDia = arr[i][j] + dp[i-1][j+1];

                dp[i][j] = Math.max(up, Math.max(leftDia, rightDia));
            }
        }

        int maxi = dp[arr.length-1][0];
        for (int i = 0; i < arr[0].length; i++) {
            maxi = Math.max(maxi, dp[arr.length-1][i]);
        }
        return maxi;
    }

    // Space Optimisation
    public static int maxPath3(int[][] arr) {

        int[] prev = new int[arr[0].length];
        for (int i = 0; i < arr[0].length; i++) {
            prev[i] = arr[0][i];
        }

        for (int i = 1; i < arr.length; i++) {
            int[] curr = new int[arr[0].length];
            for (int j = 0; j < arr.length; j++) {
                int leftDia = (int)(-1e9), rightDia = (int)(-1e9);

                int up = arr[i][j] + prev[j];
                if(j-1 >= 0) leftDia = arr[i][j] + prev[j-1];
                if(j+1 < arr[0].length) rightDia = arr[i][j] + prev[j+1];

                curr[j] = Math.max(up, Math.max(leftDia, rightDia));
            }
            prev = curr;
        }

        int maxi = prev[0];
        for (int i = 0; i < arr[0].length; i++) {
            maxi = Math.max(maxi, prev[i]);
        }
        return maxi;
    }
}
