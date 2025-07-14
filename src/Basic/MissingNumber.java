package Basic;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {0, 2, 1, 3, 5, 4, 7};
        System.out.println(findMissing(arr));
    }

    public static int findMissing(int[] arr){
        cyclic(arr);
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == 0){
                return i+1;
            }
        }
        return 0;
    }

    public static void cyclic(int[] arr){
        int i = 0;
        while(arr.length > i){
            if(arr[i] == i+1 || arr[i] == 0){
                i++;
            }
            else{
                swap(arr, i, arr[i]-1);
            }
        }
    }

    public static void swap(int[] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
