public class EvenSum{

    public static void main(String[] args){
        int[] arr = {12,24,13,48,61};

        System.out.println("Sum of Even Integers = "+ evenSum(arr));
    }

    public static int evenSum(int[] arr){
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] % 2 == 0){
                sum = sum + arr[i];
            }
        }
        return sum;
    }
}
