public class IndexOfSmallest {
    public static void main(String[] args){
        int[] arr = {12,24,0,48,60};

        int indx = smallestElementIndex(arr);
        System.out.println("Smallest Element's Index in arr is "+ indx);
    }

    public static int smallestElementIndex(int[] arr){
        int small = Integer.MAX_VALUE;
        int idx = 0;

        for(int i=0; i<arr.length; i++){
            if(arr[i] < small){
                idx = i;
                small = arr[i];
            }
        }
        return idx;
    }   
}
