public class NonZero{

    public static void main(String[] args){
        int[] arr = {12,24,0,48,60};

        int numElem = totalNonZeroElements(arr);
        System.out.println("Number of Non Zero Elements in arr is "+ numElem);
    }

    public static int totalNonZeroElements(int[] arr){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                count++;
            }
        }
        return count;
    }
}
