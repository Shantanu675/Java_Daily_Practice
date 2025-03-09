public class SearchInRange {
    public static void main(String[] args) {
        int[] arr = {12,16,3,7,26,35};

        int target = 26;

        if(rangeSearch(arr,target,2,5)){
            System.out.println("Present");
        }else{
            System.out.println("Not Present");
        }
    }

    public static boolean rangeSearch(int[] arr, int target,int start, int end){
        for(int i=start; i<end; i++){
            if(arr[i] == target){
                return true;
            }
        }
        return false;
    }
}
