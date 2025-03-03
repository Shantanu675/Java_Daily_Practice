package Basic;

public class SubArray_3105 {

    public static void main(String[] args) {
        int[] arr = {1,4,3,3,2};
        System.out.println(longestMonotonicSubarray(arr));
    }
    public static int longestMonotonicSubarray(int[] nums) {
        int maxLen = 1;
        int incSize = 1;
        int decSize = 1;

        for(int i = 1; i < nums.length; i++){
            if(nums[i-1] < nums[i]){
                decSize = 1;
                incSize++;
            }
            else if(nums[i-1] > nums[i]){
                incSize = 1;
                decSize++;
            }
            else{
                incSize = 1;
                decSize = 1;
            }
            maxLen = Math.max(maxLen, Math.max(incSize, decSize));
        }
        return maxLen;
    }
}
