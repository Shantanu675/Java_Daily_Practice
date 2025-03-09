public class Fibonacci {
    public static void main(String[] args) {
        int ans = fibo(5);
        System.out.println(ans);
    }

    public static int fibo(int n){
        if(n == 0 || n ==1){
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }
}
