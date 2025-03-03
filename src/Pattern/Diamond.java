package Pattern;

public class Diamond {
    public static void main(String[] args) {
        pattern(6);
    }
    static void pattern(int n){
        for(int i = 1; i <= 2*n; i++){
            int col = (i > n)? 2*n-i : i;

            int spaces = n - col;
            for(int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }
            for(int j = 1; j <= col; j++){
                System.out.print("x ");
            }
            System.out.println();
        }
    }
}
