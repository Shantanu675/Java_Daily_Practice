public class FindDuplicates {
    public static void main(String[] args) {
        int[] arr = {3,3,3,3,3};
        System.out.println(findDuplicate(arr));
    }

    public static int findDuplicate(int[] nums) {
        cyclicSort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return nums[i];
            }
        }

        return -1;
    }

    public static void cyclicSort(int[] arr){
        int i = 0;
        while(i < arr.length){
            if(arr[i] == i+1 || arr[i] == arr[arr[i]-1]){
                i++;
            }
            else{
                swap(arr, i, arr[i]-1);
            }
        }
    }

    public static void swap(int[] arr, int first, int second){
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}
