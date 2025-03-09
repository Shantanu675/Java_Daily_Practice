package Basic;

public class PowerOf3 {
    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }
    public static boolean isPowerOfThree(int n) {
        if(n < 1){
            return false;
        }

        while(n > 1){
            if(n % 3 != 0){
                return false;
            }
            n = n / 3;
        }
        return true;
    }
}
