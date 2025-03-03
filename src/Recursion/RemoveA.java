package Recursion;

public class RemoveA {

    static String newStr = "";

    public static void main(String[] args) {
        String str = "baccad";
        System.out.println(remove_a(str,""));
        System.out.println(remove_a(str));
        System.out.println(remove_a2(str));
    }

    public static String remove_a(String str, String newStr){
        if(str.length() == 0){
            return newStr;
        }

        if (str.charAt(0) == 'a') {
            return remove_a(str.substring(1),newStr);
        }
        newStr += str.charAt(0);
        return remove_a(str.substring(1),newStr);
    }

//    public static String remove_a(String str){
//        String newStr = "";
//        if(str.length() == 0){
//            return newStr;
//        }
//
//        if (str.charAt(0) == 'a') {
//            return remove_a(str.substring(1));
//        }
//        newStr += str.charAt(0);
//        return remove_a(str.substring(1));
//    }

    public static String remove_a(String str){
        if(str.length() == 0){
            return newStr;
        }

        if (str.charAt(0) == 'a') {
            return remove_a(str.substring(1));
        }
        newStr += str.charAt(0);
        return remove_a(str.substring(1));
    }

    public static String remove_a2(String str){
        if(str.length() == 1){
            return str;
        }

        if (str.charAt(0) == 'a') {
            return "" + remove_a2(str.substring(1));
        }

        return str.charAt(0) + remove_a2(str.substring(1));
    }
}
