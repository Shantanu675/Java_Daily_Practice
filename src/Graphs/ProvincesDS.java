package Graphs;

public class ProvincesDS {
    public static void main(String[] args) {
        int[][] matrix = {{0, 1, 0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 0, 0, 0},
                        {0, 1, 0, 0, 0, 0, 0},
                        {0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 0, 0},
                        {0, 0, 0, 0, 0, 0, 1},
                        {0, 0, 0, 0, 0, 1, 0}};
        int n = 7;
        System.out.println(countProvinces(n, matrix));
    }

    public static int countProvinces(int v, int[][] adj){
        DS ds = new DS(v+1);

        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if(adj[i][j] == 1){
                    ds.unionByRank(i+1, j+1);
                }
            }
        }

        int count = 0;
        for (int i = 1; i < v+1; i++) {
            if(ds.parent.get(i) == i){
                count++;
            }
        }
        return count;
    }
}
