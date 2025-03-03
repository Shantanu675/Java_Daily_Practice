package Basic;

class Solution {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(check(arr));
    }
    public static boolean check(int[] nums) {
        if(nums.length == 1){
            return true;
        }

        int[] arr = new int[nums.length];

        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            if(nums[i] > max){
                max = i;
            }
        }

        int n = nums.length;
        for(int i=0; i<nums.length; i++){
            arr[(i+max)%n] = nums[i];
        }

        return isSorted(arr);
    }

    public static boolean isSorted(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            if(arr[i] > arr[i+1]){
                return false;
            }
        }
        return true;
    }
}