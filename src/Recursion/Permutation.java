package Recursion;

public class Permutation {
    public static void main(String[] args) {
        String str = "abc";
        permutation("",str);
        System.out.println(permutationCount("",str));
    }

    public static void permutation(String pr, String up) {
        if(up.isEmpty()){
            System.out.println(pr);
            return;
        }
        char ch = up.charAt(0);
        for(int i=0; i<= pr.length(); i++){
            String f = pr.substring(0,i);
            String s = pr.substring(i,pr.length());

            permutation(f+ch+s,up.substring(1));
        }
    }

    public static int permutationCount(String pr, String up) {
        if(up.isEmpty()){
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for(int i=0; i<= pr.length(); i++){
            String f = pr.substring(0,i);
            String s = pr.substring(i,pr.length());

            count = count + permutationCount(f+ch+s,up.substring(1));
        }
        return count;
    }
}
