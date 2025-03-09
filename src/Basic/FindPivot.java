//In case of non-duplicate elements
public class FindPivot {

    public static void main(String[] args) {
        int[] arr = {3,1};
        int pivot = pivotFind(arr);
        System.out.println(pivot);
    }

    public static int pivotFind(int[] arr){
        int start = 0;
        int end = arr.length-1;

        while(end >= start){
            int mid = start + (end - start)/2;

            if(mid < end && arr[mid] > arr[mid+1]){
                return mid;
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid-1;
            }
            if(arr[start] >= arr[mid]){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}
