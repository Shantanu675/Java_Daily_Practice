public class Transpose {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,5},{3,1,7}};
        int[][] ans = new int[matrix[0].length][matrix.length];

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                ans[i][j] = matrix[j][i];
            }
        }

        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[0].length; j++){
                System.out.print(ans[i][j]+" ");
            }
            System.out.println();
        }
    }
}
