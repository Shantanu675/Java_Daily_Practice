import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        int[] arr = {5,7,7,8,8,10,12};
        int target = 12;

        System.out.println(Arrays.toString(firstAndLastPosition(arr,target)));
    }

    public static int[] firstAndLastPosition(int[] arr, int target){
        int[] ans = {-1,-1};
        //check for first occurence if target first
        int start = binarySearch(arr,target,true);//make it true to go left

        //if above search return -1 means no target present in given arr
        //so dont check other
        int end = binarySearch(arr,target,false);//make it fasle to go right

        ans[0] = start;
        ans[1] = end;

        return ans;
    }

    public static int binarySearch(int[] arr, int target, boolean findStart){
        int ans = -1;

        int start = 0;
        int end = arr.length-1;

        while(start <=end){
            int mid = start + (end - start) /2;


            if(arr[mid] == target){
                ans = mid;
                //Below block of code find target element left side till loop break to get first position
                if(findStart){
                    end = mid - 1;
                }
                //Below block of code find target element right side till loop break to get last position
                else{
                    start = mid + 1;
                }
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }
}
