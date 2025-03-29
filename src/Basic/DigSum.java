public class DigSum {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,5},{7,1,7}};

        int sum = digSum(matrix);
        System.out.println("Sum of Diagonal elements in Matrix = "+sum);
    }

    public static int digSum(int[][] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i==j){
                    sum = sum + arr[i][j];
                }
            }
        }
        return sum;  
    } 
}
