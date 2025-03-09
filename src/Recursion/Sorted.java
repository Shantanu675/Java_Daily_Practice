public class Sorted {
    public static void main(String[] args) {
        int[] arr = {2,4,8,60,12};
        System.out.println(isSorted(arr,0));
    }

    public static boolean isSorted(int[] arr, int indx){
        if(indx == arr.length-1){
            return true;
        }
        return (arr[indx] < arr[indx+1]) && isSorted(arr,indx+1);
    }
}
