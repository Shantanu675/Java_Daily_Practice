package Basic;

import java.util.ArrayList;

public class Operator {
    public static void main(String[] args) {
        System.out.println('a'+'b');
        System.out.println("a" + "b");
        System.out.println('a' + 3);
        System.out.println((char)('a' + 3));
        System.out.println(3 + 2 + "a" + 1);

        System.out.println("Shantanu" + new ArrayList<>());
        System.out.println("Shantanu" + new String("56"));
        System.out.println("Shantanu" + new Integer(56)); // Deprecated

//        System.out.println(new Integer(56) + new ArrayList<>()); // + use on premetive and if any one is String
        System.out.println(new Integer(56) + "" + new ArrayList<>());
    }
}
