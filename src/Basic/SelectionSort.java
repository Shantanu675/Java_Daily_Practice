import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 3};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selection(int[] arr){
        for(int i=0; i<arr.length; i++) {
            int last = arr.length - i - 1;
            int maxIndx = getMaxIndex(arr, 0, last);
            swapped(arr, maxIndx, last);
        }
    }

    public static void swapped(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static int getMaxIndex(int[] arr,int start, int last){
        int max = start;
        for(int i=0; i<last+1; i++){
            if(arr[i] > arr[max]){
                max = i;
            }
        }
        return max;
    }
}
