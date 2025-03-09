public class BinarySearchSQRT {
    public static void main(String[] args) {
        System.out.printf("%.3f",sqrt(40,3));
    }

    public static double sqrt(int num,int p){
        int start = 0;
        int end = num;

        double root = 0.0;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(mid * mid == num){
                return mid;
            }
            else {
                if (mid * mid > num) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        double incr = 0.1;
        for(int i = 0; i < p; i++){
            while(root * root <= num){
                root += incr;
            }
            root -= incr;
            incr /= 10;
        }
        return root;
    }
}
