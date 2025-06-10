package EnumEx;

import java.util.Arrays;

enum Status{
    Running, Failed, Pending, Success;
}

public class Main {
    public static void main(String[] args) {
        Status sta = Status.Pending;
        System.out.println(sta);
        System.out.println(sta.ordinal());

        Status[] arr = Status.values();
        System.out.println(Arrays.toString(arr));
    }
}
