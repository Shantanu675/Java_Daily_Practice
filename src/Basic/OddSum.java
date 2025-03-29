public class OddSum{

    public static void main(String[] args){
        int[] arr = {12,24,13,48,61};

        System.out.println("Sum of Odd Integers = "+ oddSum(arr));
    }

    public static int oddSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 != 0){
                sum = sum + arr[i];
            }
        }
        return sum;
    }
}
