public class RevDigit {
    static int sum = 0;
    public static void rev(int n){
        if(n == 0){
            return;
        }
        int rem = n % 10;
        sum = sum*10 + rem;
        rev(n/10);
    }

    public static void main(String[] args) {
        rev(1234);
        System.out.println(sum);
    }
}
