public class Largest{

    public static void main(String[] args){
        int[] arr = {12,24,0,48,60};

        int large = largestElement(arr);
        System.out.println("Largest Elements in arr is "+ large);
    }

    public static int largestElement(int[] arr){
        int large = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] > large){
                large = arr[i];
            }
        }
        return large;
    }
}
