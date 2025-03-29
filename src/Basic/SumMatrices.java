public class SumMatrices {
    public static void main(String[] args){
        int[][] mat1 = {{1,2,3},{4,5,5},{3,1,7}};
        int[][] mat2 = {{1,4,3},{1,3,4},{3,1,1}};
        
        int[][] ans = new int[mat1.length][mat1[0].length];

        if(mat1.length == mat2.length && mat1[0].length == mat2[0].length){
            for(int i=0; i<mat1.length; i++){
                for(int j=0; j<mat1[0].length; j++){
                    ans[i][j] = mat1[i][j] + mat2[i][j];
                }
            }

            for(int i=0; i<ans.length; i++){
                for(int j=0; j<ans[0].length; j++){
                    System.out.print(ans[i][j]+" ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("Addition Not possible");
        }
    }
}
