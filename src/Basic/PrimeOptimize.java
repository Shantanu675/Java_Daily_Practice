public class PrimeOptimize {
    public static void main(String[] args) {
        int n = 37;
        boolean[] prime = new boolean[n+1];
        sieve(n, prime);
    }

    public static void sieve(int n, boolean[] prime) {
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            // If prime[p] is not changed, then it is a
            // prime
            if (prime[p] == true) {
                // Update all multiples of p greater than or
                // equal to the square of it numbers which
                // are multiple of p and are less than p^2
                // are already been marked.
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for(int i=2; i<prime.length; i++){
            if(prime[i] == true){
                System.out.print(i+" ");
            }
        }
    }
}
