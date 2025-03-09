import java.util.Scanner;

public class Hakkerrank {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";

        String refString = s.substring(0,k);

        for(int i=1; i<=s.length()-k; i++){
            String newString = s.substring(i,i+3);
            if(refString.compareTo(newString) < 0){
                smallest = newString;
            }
            refString = smallest;
        }

        for(int i=1; i<=s.length()-k; i++){
            String newString = s.substring(i,i+3);
            if(refString.compareTo(newString) > 0){
                largest = refString;
            }
            refString = largest;
        }

        return smallest + "\n" + largest;
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();

        System.out.println(getSmallestAndLargest(s, k));
    }
}