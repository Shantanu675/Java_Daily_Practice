package Greedy;

import java.util.Arrays;

public class Railway {
    public static void main(String[] args) {
        int[] arr = {900, 1100, 1235}; // {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {1000, 1200, 1240}; // {910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(findPlatform(arr, dep));
    }

    public static int findPlatform(int[] arr, int[] dep) {
        int n = arr.length;
        Arrays.sort(arr);
        Arrays.sort(dep);

        int platforms = 1;
        int maxPlatforms = 1;

        int i = 1;
        int j = 0;

        while(i < n && j < n) {
            if(arr[i] < dep[j]) {
                platforms++;
                i++;
            }
            else {
                platforms--;
                j++;
            }

            maxPlatforms = Math.max(platforms, maxPlatforms);
        }
        return maxPlatforms;
    }
}
