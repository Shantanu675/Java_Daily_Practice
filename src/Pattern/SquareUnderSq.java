package Pattern;

public class SquareUnderSq {
    public static void main(String[] args) {
        pattern(3);
    }
    public static void pattern(int n){
        n = 2*n;
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= n; j++){
                int c = Math.min(Math.min(i,j),Math.min(n-i,n-j));
                System.out.print(c);
            }
            System.out.println();
        }
    }
}
