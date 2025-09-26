public class ExtendedEucledian {
    // Function to find GCD and coefficients (Extended Euclidean Algorithm)
    private static int gcdExtended(int a, int b, int[] xy) {
        if (a == 0) {
            xy[0] = 0;
            xy[1] = 1;
            return b;
        }

        int[] xy1 = new int[2];
        int gcd = gcdExtended(b % a, a, xy1);

        // Update x and y using results of recursion
        xy[0] = xy1[1] - (b / a) * xy1[0];
        xy[1] = xy1[0];

        return gcd;
    }

    // Function to find multiplicative inverse of a under modulo m
    public static int modInverse(int a, int m) {
        int[] xy = new int[2]; // To store x and y
        int gcd = gcdExtended(a, m, xy);

        if (gcd != 1) {
            // Inverse doesn't exist
            throw new ArithmeticException("Inverse doesn't exist (numbers not coprime)");
        } else {
            // m is added to handle negative x
            return (xy[0] % m + m) % m;
        }
    }

    public static void main(String[] args) {
        int a = 3;
        int m = 11;

        try {
            int inverse = modInverse(a, m);
            System.out.println("Multiplicative inverse of " + a + " mod " + m + " is: " + inverse);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

