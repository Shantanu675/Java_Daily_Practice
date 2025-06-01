package BigDecimal;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BD();
    }

    static void BD(){
        double x = 0.03;
        double y = 0.04;
        double ans = y-x;
        System.out.println(ans);

        BigDecimal X = new BigDecimal("0.04");
        BigDecimal Y = new BigDecimal("0.03");
        BigDecimal Ans = X.subtract(Y);
        System.out.println(Ans);

        BigDecimal c = BigDecimal.TEN;
        System.out.println(c);
    }
}
