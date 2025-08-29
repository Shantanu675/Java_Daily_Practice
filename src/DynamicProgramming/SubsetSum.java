package DynamicProgramming;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        System.out.println(isPossible(arr));
    }

    private static boolean isPossible(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return isSubSeqAvail(arr, sum / 2);
    }

    private static boolean isSubSeqAvail(int[] arr, int target) {
        return helper(arr.length - 1, arr, target);
    }

    private static boolean helper(int indx, int[] arr, int target) {
        if (target == 0) return true;
        if (indx == 0) return target == arr[0];

        boolean notTaken = helper(indx - 1, arr, target);
        boolean taken = false;
        if (target >= arr[indx]) {
            taken = helper(indx - 1, arr, target - arr[indx]);
        }
        return notTaken || taken;
    }
}
