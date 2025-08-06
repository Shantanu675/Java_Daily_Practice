package DynamicProgramming;

public class NinjaTask {
    public static void main(String[] args) {
        int[][] tasks = {{2, 1, 3},
                {3, 4, 6},
                {10, 1, 6},
                {8, 3, 7}};

        System.out.println(ninjaMaxCredits(tasks));
        System.out.println(ninjaMaxCredits1(tasks));
        System.out.println(ninjaMaxCredits2(tasks));
        System.out.println(ninjaMaxCredits3(tasks));
    }

    // Space Optimization
    private static int ninjaMaxCredits3(int[][] tasks) {
        int n = tasks.length;
        int[] prev = new int[4];

        prev[0] = Math.max(tasks[0][1], tasks[0][2]);
        prev[1] = Math.max(tasks[0][0], tasks[0][2]);
        prev[2] = Math.max(tasks[0][0], tasks[0][1]);
        prev[3] = Math.max(tasks[0][0], Math.max(tasks[0][1], tasks[0][2]));

        for (int d = 1; d < n; d++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                temp[last] = 0;
                for (int i = 0; i < 3; i++) {
                    if(i != last){
                        int point = tasks[d][i] + prev[i];
                        temp[last] = Math.max(temp[last], point);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }

    // Tabulation
    private static int ninjaMaxCredits2(int[][] tasks) {
        int n = tasks.length;
        int[][] dp = new int[n][4];
        return f2(n-1, tasks, dp);
    }

    private static int f2(int day, int[][] tasks, int[][] dp) {
        dp[0][0] = Math.max(dp[0][1], dp[0][2]);
        dp[0][1] = Math.max(dp[0][0], dp[0][2]);
        dp[0][2] = Math.max(dp[0][0], dp[0][1]);
        dp[0][3] = Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));

        for (int d = 1; d <= day; d++) {
            for (int last = 0; last < 4; last++) {
                dp[d][last] = 0;
                for (int i = 0; i < 3; i++) {
                    if(i != last){
                        int point = tasks[day][i] + dp[day-1][i];
                        dp[d][last] = Math.max(dp[d][last], point);
                    }
                }
            }
        }
        return dp[day-1][3];
    }

    // Memoization
    private static int ninjaMaxCredits1(int[][] tasks) {
        int n = tasks.length;
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                dp[i][j] = -1;
            }
        }
        return f1(n-1, 3, tasks, dp);
    }

    private static int f1(int day, int last, int[][] tasks, int[][] dp) {
        if(dp[day][last] != -1) return dp[day][last];
        if(day == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if(i != last){
                    maxi = Math.max(maxi, tasks[0][i]);
                }
            }
            return dp[day][last] = maxi;
        }

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if(i != last){
                int point = tasks[day][i] + f1(day-1, i, tasks, dp);
                maxi = Math.max(maxi, point);
            }
        }
        return dp[day][last] = maxi;
    }

    // Recursion
    private static int ninjaMaxCredits(int[][] tasks) {
        int n = tasks.length;
        return f(n-1, 3, tasks);
    }

    private static int f(int day, int last, int[][] tasks) {
        if(day == 0) {
            int maxi = 0;
            for (int i = 0; i < 3; i++) {
                if(i != last) {
                    maxi = Math.max(maxi, tasks[0][i]);
                }
            }
            return maxi;
        }

        int maxi = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int point = tasks[day][i] + f(day-1, i, tasks);
                maxi = Math.max(point, maxi);
            }
        }
        return maxi;
    }
}
