public class NumOfElem{

    public static void main(String[] args){
        int[] arr = {12,24,36,48,60};

        int numElem = totalElements(arr);
        System.out.println("Number of Elements in arr is "+ numElem);
    }

    public static int totalElements(int[] arr){
        int count = 0;
        for(int i=0; i<arr.length; i++){
            count++;
        }
        return count;
    }
}
