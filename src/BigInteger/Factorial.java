package BigInteger;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        BigInteger ans = new BigInteger("1");

        for(int i = 1; i <= 100; i++){
            ans = ans.multiply(BigInteger.valueOf(i));
        }

        System.out.println(ans);
    }
}
