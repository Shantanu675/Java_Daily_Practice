package Basic;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] arr = {23,145,83,21,76,90,9};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        int max = Arrays.stream(arr).max().getAsInt();

        for(int exp = 1; max/exp > 0; exp *= 10){
            countSort(arr, exp);
        }
    }

    private static void countSort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] freq = new int[10];

        for (int i = 0; i < n; i++) {
            freq[(arr[i] / exp)%10]++;
        }

        for (int i = 1; i < 10; i++) {
            freq[i] = freq[i] + freq[i-1];
        }

        for (int i = n-1; i >= 0; i--) {
            output[freq[(arr[i] / exp)%10]-1] = arr[i];
            freq[(arr[i] / exp)%10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }
}
