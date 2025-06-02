package Basic;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] arr = {3,4,1,3,2,5,2,8};
        System.out.println(Arrays.toString(sort(arr)));
    }

    public static int[] sort(int[] arr){
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] > max){
                max = i;
            }
        }

        int[] freq = new int[arr[max]+1];
        for (int i = 0; i < arr.length; i++) {
            freq[arr[i]]++;
        }

        //int[] ans = new int[arr.length];
        int j = 0;
        for (int i = 0; i < freq.length; i++) {
            while(freq[i] > 0){
                arr[j] = i;
                j++;
                freq[i]--;
            }
        }
        return arr;
    }
}
