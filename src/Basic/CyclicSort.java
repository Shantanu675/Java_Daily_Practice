import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        cyclic(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void cyclic(int[] arr){
        int i = 0;
        while(i < arr.length){
            if(arr[i] == i+1){
                i++;
            }
            else{
                swapped(arr, i, arr[i]-1);
            }
        }
    }

    public static void swapped(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
