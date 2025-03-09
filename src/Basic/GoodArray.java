public class GoodArray {

    public static void main(String[] args) {
        int[] arr = {6, 10, 15};
        System.out.println(isGoodArray(arr));
    }

    public static boolean isGoodArray(int[] nums) {
        for(int element : nums){
            for(int elem : nums){
                if(calculateGCD(element, elem) == 1){
                    return true;
                }
            }
        }
        return false;
    }

    public static int calculateGCD(int number1, int number2){
        int a;
        int b;
        int remainder;

        if(number1 > number2){
            a = number1;
            b = number2;
        }else{
            a = number2;
            b = number1;
        }

        remainder = a % b;
        while (remainder != 0){
            a = b;
            b = remainder;
            remainder   = a % b;
        }

        return b;
    }
}
