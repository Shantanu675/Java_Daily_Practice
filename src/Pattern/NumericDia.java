package Pattern;

public class NumericDia {
    public static void main(String[] args) {
        pattern(6);
    }
    static void pattern(int n){
        for(int i = 1; i <= 2*n; i++){
            int c = i>n ? 2*n-i : i;

            for(int x = 0; x <= n-c; x++){
                System.out.print("  ");
            }
            for(int j = c; j >= 1; j--){
                System.out.print(j+" ");
            }
            for(int j = 2; j <= c; j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
