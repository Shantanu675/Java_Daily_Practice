public class Descending{
    public static void main(String[] args){
        int[] arr = {12,24,78,48,61};

        System.out.println("Descending Order : \n");
        increasingSorting(arr);

        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i]+"\t");
        }
    }

    public static void increasingSorting(int[] arr){
        int n = arr.length;
        for(int i=0; i < n-1; i++){
            for(int j=0; j< n-i-1; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}