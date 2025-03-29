public class LargestInMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,5},{7,1,7}};

        int large = large(matrix);
        System.out.println("Largest element in Matrix = "+large);
    }

    public static int large(int[][] arr){
        int large = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(large < arr[i][j]){
                    large = arr[i][j];
                }
            }
        }
        return large;  
    } 
}
