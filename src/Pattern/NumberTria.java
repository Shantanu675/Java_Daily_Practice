package Pattern;

public class NumberTria {
    public static void main(String[] args) {
        pattern(6);
    }
    static void pattern(int n){
        for(int i = 1; i <= n; i++){
            for(int x = 0; x <= n-i; x++){
                System.out.print("  ");
            }
            for(int j = i; j >= 1; j--){
                System.out.print(j+" ");
            }
            for(int j = 2; j <= i; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
