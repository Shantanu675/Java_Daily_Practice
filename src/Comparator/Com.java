package Comparator;

import java.util.*;

public class Com {
    public static void main(String[] args) {
        Comparator<String> com = new Comparator<String>() {
            @Override
            //---------------------------------------------
//            public int compare(String i, String j) {
//                if(i.%10 > j%10){
//                    return 1;
//                }
//                else{
//                    return -1;
//                }
//            }
            //----------------------------------------------
            public int compare(String i, String j) {
                if(i.length() > j.length()){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            //----------------------------------------------
        };

        List<String> list = new ArrayList<>();
        list.add("43");
        list.add("abc");
        list.add("ab");
        list.add("a");

        Collections.sort(list, com);
        System.out.println(list);
    }
}
