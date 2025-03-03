package Recursion;

public class DieCombination {
    public static void main(String[] args) {
        //getCombinations("",8);
        getCombinations("",6,5);//custom fsce die with 5 faces
    }

    public static void getCombinations(String p, int up){
        if(up == 0){
            System.out.println(p);
            return;
        }

        for(int i=1; i<=6 && i<=up; i++){
            String ch = Integer.toString(i);
            getCombinations(p+ch,up-i);
        }
    }

    public static void getCombinations(String p, int up, int face){
        if(up == 0){
            System.out.println(p);
            return;
        }

        for(int i=1; i<=face && i<=up; i++){
            String ch = Integer.toString(i);
            getCombinations(p+ch,up-i);
        }
    }
}
