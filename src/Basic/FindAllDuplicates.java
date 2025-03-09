import java.util.*;

public class FindAllDuplicates {
    public static void main(String[] args) {
        int[] arr = {4,3,2,7,8,2,3,1};

        List<Integer> list = findDuplicates(arr);
        System.out.println(list);
    }

    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();

        cyclicSort(nums);

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                list.add(nums[i]);
            }
        }

        return list;
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
