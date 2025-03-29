public class Smallest{

    public static void main(String[] args){
        int[] arr = {12,24,0,48,60};

        int small = smallestElement(arr);
        System.out.println("Smallest Elements in arr is "+ small);
    }

    public static int smallestElement(int[] arr){
        int small = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++){
            if(arr[i] < small){
                small = arr[i];
            }
        }
        return small;
    }
}
