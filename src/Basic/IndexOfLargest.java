public class IndexOfLargest {
    public static void main(String[] args){
        int[] arr = {12,24,90,48,60};

        int indx = largestElementIndex(arr);
        System.out.println("Largestest Element's Index in arr is "+ indx);
    }

    public static int largestElementIndex(int[] arr){
        int large = Integer.MIN_VALUE;
        int idx = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] > large){
                idx = i;
                large = arr[i];
            }
        }
        return idx;
    }   
}
