public class Fibo {
    public static void main(String[] args) {
        long term = 53;
        System.out.println(fibo(term));
    }

    public static long fibo(long n){
        return (long)((1/Math.sqrt(5))*(Math.pow(((1 + Math.sqrt(5))/2),n) - Math.pow(((1 - Math.sqrt(5))/2),n)));
    }
}
