package Pattern;

public class NumericTria {
       public static void main(String[] args) {
            pattern(6);
       }
       static void pattern(int n){
            for(int i = 1; i <= n; i++){
                int num = 1;
                for(int j = 1; j <= i; j++){
                    System.out.print(num+" ");
                    num++;
                }
                System.out.println();
            }
       }
}
