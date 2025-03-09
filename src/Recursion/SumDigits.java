public class SumDigits {
    public static void main(String[] args) {
        System.out.println(sum(1234));
    }

    public static int sum(int n){
        if(n == 0){
            return  0;
        }
//        int rem = n % 10;
//        sum += rem;
//        return sum(n/10,sum);
        return sum(n/10) + (n%10);
    }
}
