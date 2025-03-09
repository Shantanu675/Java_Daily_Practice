import java.util.Arrays;

public class Scope {
    public static void main(String[] args) {
        fun("Kunal","Shantanu","Sharvari");
        fun(1,34,72,83,95);
    }

    static void fun(int ...nums){
        System.out.println(Arrays.toString(nums));
    }

    static void fun(String ...nums){
        System.out.println(Arrays.toString(nums));
    }
}
