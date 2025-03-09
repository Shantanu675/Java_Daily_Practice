package Recursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 5, 4, 8, 6};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }

        int low = 0;
        int high = arr.length - 1;

        int pivotIndex = partition(arr, low, high);
        int[] left = Arrays.copyOfRange(arr, low, pivotIndex);
        int[] right = Arrays.copyOfRange(arr, pivotIndex + 1, high + 1);

        quickSort(left);
        quickSort(right);

        System.arraycopy(left, 0, arr, 0, left.length);
        arr[left.length] = arr[pivotIndex];
        System.arraycopy(right, 0, arr, left.length + 1, right.length);
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
