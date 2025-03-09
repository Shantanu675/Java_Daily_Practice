public class Floor {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 23;

        System.out.println(ceil(arr,target));
    }
    public static int ceil(int[] arr, int target){
        //when target is smaller than first(smallest) element in an array -> No floor
        if(target < arr[0]){
            return -1;
        }

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return end;
    }
}
