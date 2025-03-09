public class InfiniteArray {

    public static void main(String[] args) {
        int[] arr = { 3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};

        int target = 10;
        int ans = findRange(arr, target);
        System.out.println(ans);
    }

    public static int findRange(int[] arr, int target){
        //first find range in which target will lie
        int start = 0;
        int end = 1;

        while(arr[end] < target){
            int temp = end+1;
            end = end+(end-start+1)*2;//double the box size and take after end indx
            start = temp;
        }
        return searchBinary(arr,target,start,end);
    }

    public static int searchBinary(int[] arr, int target, int start, int end){
        while(start <= end){
            int mid = start + (end - start) /2;

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
        return -1;
    }
}
