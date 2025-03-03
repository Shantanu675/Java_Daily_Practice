package Recursion;

public class PhonePad {
    public static void main(String[] args) {
        phonePad("","19");
        System.out.println(phonePadCount("","12"));
    }

    public static void phonePad(String pr, String up) {
        if(up.isEmpty()){
            System.out.println(pr);
            return;
        }

        int digit = up.charAt(0)-'0';
        for(int i=(digit-1)*3; i<digit*3; i++){
            if(i == 26){
                return;
            }
            else {
                char ch = (char) ('a' + i);
                phonePad(pr + ch, up.substring(1));
            }
        }
    }

    public static int phonePadCount(String pr, String up) {
        if(up.isEmpty()){
            return 1;
        }

        int count=0;
        int digit = up.charAt(0)-'0';
        for(int i=(digit-1)*3; i<digit*3; i++){
            if(i == 26){
                return 0;
            }
            else {
                char ch = (char) ('a' + i);
                count = count + phonePadCount(pr + ch, up.substring(1));
            }
        }

        return count;
    }
}
