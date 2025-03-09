package cvb;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PivotArray {
    public static void main(String[] args) {
        int[] arr  = {-3,4,3,2};
        System.out.println(Arrays.toString(pivotArray(arr, 2)));
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] ans = new int[nums.length];
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0; i<nums.length; i++){
            if(nums[i] < pivot){
                q1.add(nums[i]);
            }
        }

        for(int i=0; i<nums.length; i++){
            if(nums[i] > pivot){
                q2.add(nums[i]);
            }
        }

        int q1Size = q1.size();
        int q2Size = q2.size();
        int numOfPivot = nums.length - q1Size - q2Size;

        for(int i=0; i<q1Size; i++){
            ans[i] = q1.poll();
        }
        for(int i=q1Size; i < q1Size+numOfPivot; i++){
            ans[i] = pivot;
        }
        for(int i = q1Size+numOfPivot; i < q1Size+numOfPivot+q2Size; i++){
            ans[i] = q2.poll();
        }

        return ans;
    }
}
