public class BinarySearchRecu {
    public static void main(String[] args) {
        int[] arr = {2,4,6,8,10,14};
        int target = 2;
        System.out.println(search(arr,target, 0, arr.length-1));
    }

    public static int search(int[] arr, int target, int start, int end){
        if(end < start){
            return -1;
        }

        int mid = start + (end - start)/2;
        if(target == arr[mid]){
            return mid;
        }

        if(target > arr[mid]){
            return search(arr, target, mid+1, end);
        }
        return search(arr, target, start, mid-1);
    }
}
