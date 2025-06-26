package Graphs;

public class MinNeighbours {
    public static void main(String[] args) {
        int[][] edges = {{0,1,3}, {1,2,1}, {1,3,4}, {2,3,1}};
        int n = 4;
        int m = 4;
        int distanceThreshold = 4;
        System.out.println(findCity(n, m, edges, distanceThreshold));
    }

    private static int findCity(int n, int m, int[][] edges, int distanceThreshold) {
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = (int)1e9;
                if(i == j){
                    cost[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            cost[u][v] = wt;
            cost[v][u] = wt;
        }

        for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][via] + cost[via][j]);
                }
            }
        }

        // find min neighbours
        int minNeigh = n+1;
        int city = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if(cost[i][j] <= distanceThreshold){
                    count++;
                }
            }
            if(count <= minNeigh){
                minNeigh = count;
                city = i;
            }
        }
        return city;
    }
}
