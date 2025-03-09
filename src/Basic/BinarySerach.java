public class BinarySerach {
    public static void main(String[] args) {
        int[] arr = {12,24,36,48,60};

        int target = 36;

        int indx = search(arr,target);
        System.out.println(indx);
    }

    public static int search(int[] arr, int target){
        int start = 0;
        int end = arr.length-1;

        while(start <=end){
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
