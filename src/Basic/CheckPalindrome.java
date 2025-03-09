public class CheckPalindrome {
    public static void main(String[] args) {
        String str = "racecar";
        System.out.println(checkPalindrome(str));
    }

    public static boolean checkPalindrome(String str){
        int ptr1 = 0;
        int ptr2 = str.length()-1;

        for(int i = 0; i < str.length()/2; i++){
            if(str.charAt(ptr1) == str.charAt(ptr2)){
                ptr1++;
                ptr2--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}
