public class SumArray{

    public static void main(String[] args){
        int[] arr = {12,24,0,48,60};

        System.out.println("Array Sum = "+ arrSum(arr));
    }

    public static int arrSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }
}
