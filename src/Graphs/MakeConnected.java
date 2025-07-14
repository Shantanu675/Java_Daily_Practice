package Graphs;

public class MakeConnected {
    public static void main(String[] args) {
        //int[][] arr = {{0,1}, {0,3}, {0,2}, {1,2}, {2,3}, {4,5}, {5,6}, {7,8}};
        //int n = 9;
        int[][] arr = {{0,1}, {0,2}, {1,2}};
        int n = 4;
        System.out.println(connectedBy(n, arr));
    }

    private static int connectedBy(int n, int[][] arr) {
        DS d = new DS(n-1);
        int components = 0;
        int extraEdges = 0;

        for (int i = 0; i < arr.length ; i++) {
            int u = arr[i][0];
            int v = arr[i][1];

            if(d.findParent(u) != d.findParent(v)){
                d.unionByRank(u, v);
            } else {
                extraEdges++;
            }
        }

        for (int i = 0; i < n; i++) {
            if(d.findParent(i) == i) {
                components++;
            }
        }

        if(components - 1 > extraEdges) {
            return -1;
        }
        return components - 1;
    }
}
