package Pattern;

public class ReverseTria {
    public static void main(String[] args) {
        pattern(6);
    }
    static void pattern(int n){
        for(int i = 1; i <= n; i++){
            for(int j = n; j >= i ; j--){
                System.out.print("x ");
            }
            System.out.println();
        }
    }
}