package DynamicProgramming;

public class ChicolatesCollections {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 3, 1, 2},
                {3, 4, 2, 2},
                {5, 6, 3, 5}
        };

        System.out.println(maxCollection(grid, 0, grid[0].length-1));
        System.out.println(maxCollection1(grid, 0, grid[0].length-1));
    }

    //Memoization
    private static int maxCollection1(int[][] grid, int as, int bs) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                for (int k = 0; k < grid[0].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        return recursion1(grid, 0, as, bs, dp);
    }

    private static int recursion1(int[][] grid, int i, int j1, int j2, int[][][] dp) {
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return (int)-1e8;
        }

        if(i == grid.length-1) {
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        if(dp[i][j1][j2] != -1) return dp[i][j1][j2];

        int maxi = (int)-1e8;
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                if(j1 == j2) maxi = Math.max(maxi , grid[i][j1] + recursion1(grid, i+1, j1 + dj1, j2 + dj2, dp));
                else maxi = Math.max(maxi , grid[i][j1] + grid[i][j2] + recursion1(grid, i+1, j1 + dj1, j2 + dj2, dp));
            }
        }
        return dp[i][j1][j2] = maxi;
    }

    // Recursion
    private static int maxCollection(int[][] grid, int as, int bs) {
        return recursion(grid, 0, as, bs);
    }

    private static int recursion(int[][] grid, int i, int j1, int j2) {
        if(j1 < 0 || j1 >= grid[0].length || j2 < 0 || j2 >= grid[0].length) {
            return (int)-1e8;
        }

        if(i == grid.length-1) {
            if(j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }

        int maxi = (int)-1e8;
        for(int dj1 = -1; dj1 <= 1; dj1++) {
            for(int dj2 = -1; dj2 <= 1; dj2++) {
                if(j1 == j2) maxi = Math.max(maxi , grid[i][j1] + recursion(grid, i+1, j1 + dj1, j2 + dj2));
                else maxi = Math.max(maxi , grid[i][j1] + grid[i][j2] + recursion(grid, i+1, j1 + dj1, j2 + dj2));
            }
        }
        return maxi;
    }
}

