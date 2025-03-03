package Recursion;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3,2,6,1,5,9};
        int[] ans = mergeSort(arr);
        System.out.println(Arrays.toString(ans));

        mergeSortInPlace(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));

    }

    public static int[] mergeSort(int[] arr){
        if(arr.length == 1){
            return arr;
        }

        int mid = arr.length / 2;

        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    public static int[] merge(int[] left, int[] right){
        int ptr1 = 0;
        int ptr2 = 0;
        int newPtr = 0;

        int[] ans = new int[left.length + right.length];

        while(ptr1 < left.length && ptr2 < right.length) {
            if (left[ptr1] < right[ptr2]) {
                ans[newPtr] = left[ptr1];
                ptr1++;
            }
            else {
                ans[newPtr] = right[ptr2];
                ptr2++;
            }
            newPtr++;
        }

        while(ptr1 < left.length){
            ans[newPtr] = left[ptr1];
            ptr1++;
            newPtr++;
        }

        while(ptr2 < right.length){
            ans[newPtr] = right[ptr2];
            ptr2++;
            newPtr++;
        }

        return ans;
    }



    public static void mergeSortInPlace(int[] arr, int s, int e){
        if(e-s == 1){
            return;
        }

        int mid = (s+e)/ 2;

        mergeSortInPlace(arr, s, mid);
        mergeSortInPlace(arr, mid, e);

        mergeInPlace(arr, s, mid, e);
    }

    public static void mergeInPlace(int[] arr, int s, int mid, int e){
        int ptr1 = s;
        int ptr2 = mid;
        int newPtr = 0;

        int[] ans = new int[e-s];

        while(ptr1 < mid && ptr2 < e) {
            if (arr[ptr1] < arr[ptr2]) {
                ans[newPtr] = arr[ptr1];
                ptr1++;
            }
            else {
                ans[newPtr] = arr[ptr2];
                ptr2++;
            }
            newPtr++;
        }

        while(ptr1 < mid){
            ans[newPtr] = arr[ptr1];
            ptr1++;
            newPtr++;
        }

        while(ptr2 < e){
            ans[newPtr] = arr[ptr2];
            ptr2++;
            newPtr++;
        }

        for(int i = 0; i < ans.length; i++){
            arr[s+i] = ans[i];
        }
    }
}
