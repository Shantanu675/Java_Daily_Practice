package BigInteger;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        int x = 30;
        int y = 67;

        BigInteger a = BigInteger.valueOf(33); // convert 33 inti bigInteger
        BigInteger b = BigInteger.valueOf(345678);
        BigInteger c = new BigInteger("3456789897543796789098765432348976543");

        // constants
        BigInteger d = BigInteger.TEN;

        // addition
        BigInteger s = c.add(d);

        System.out.println(s);
    }
}
