package DynamicProgramming;

import java.util.Arrays;

public class RobberInHouse {
    public static void main(String[] args) {
        int[] arr = {2, 3, 2};
        System.out.println(houseRobber(arr.length, arr));
    }

    private static int houseRobber(int length, int[] arr) {
        int[] temp1 = Arrays.copyOfRange(arr, 0, arr.length-1);
        int[] temp2 = Arrays.copyOfRange(arr, 1, arr.length);

        return Math.max(help(temp1.length, temp1), help(temp2.length, temp2));
    }

    public static int help(int n, int[] arr){
        int prev = arr[0];
        int prev2 = 0;
        int curi = 0;

        for (int i = 1; i < n; i++) {
            int pick = prev2 + arr[i];
            int nonpick = prev + 0;

            curi = Math.max(pick, nonpick);

            prev2 = prev;
            prev = curi;
        }
        return curi;
    }
}
