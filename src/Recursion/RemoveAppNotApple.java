package Recursion;

public class RemoveAppNotApple {

    static String newStr = "";

    public static void main(String[] args) {
        String str = "baccappeyyudapp";
        System.out.println(remove_apple(str,""));
        System.out.println(remove_a(str));
        System.out.println(remove_a2(str));
    }

    public static String remove_apple(String str, String newStr){
        if(str.length() == 0){
            return newStr;
        }

        if (str.startsWith("app") && !str.startsWith("apple")) {
            return remove_apple(str.substring(3),newStr);
        }
        newStr += str.charAt(0);
        return remove_apple(str.substring(1),newStr);
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

        if (str.startsWith("app") && !str.startsWith("apple")) {
            return remove_a(str.substring(3));
        }
        newStr += str.charAt(0);
        return remove_a(str.substring(1));
    }

    public static String remove_a2(String str){
        if(str.length() <= 1){
            return str;
        }

        if (str.startsWith("app") && !str.startsWith("apple")) {

            return remove_a2(str.substring(3));
        }

        return str.charAt(0) + remove_a2(str.substring(1));
    }
}

