package Recursion;

import java.util.Arrays;

public class SumArray {
    public static void main(String[] args) {
        int[] arr = {2,6,4,9,0,1};
        System.out.println(getSum(arr));
    }

    public static int getSum(int[] arr){
        if(arr.length == 1){
            return arr[0];
        }
        return getSum(Arrays.copyOfRange(arr,1,arr.length)) + arr[0];
    }
}
