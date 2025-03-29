public class MergeArray {
    public static void main(String[] args){
        int[] arr1 = {12,24,10,48,6};
        int[] arr2 = {35,28,21,14,7};

        System.out.println(" Merged Array = ");
        merge(arr1, arr2);
    }

    public static void merge(int[] arr1, int[] arr2){
        int size1 = arr1.length;
        int size2 = arr2.length;

        int[] arr = new int[size1 + size2];

        for(int i=0; i<arr1.length; i++){
            arr[i] = arr1[i];
        }
        for(int i=size1; i < size1+size2; i++){
            arr[i] = arr2[i-size1];
        }

        //printing of merged array
        for(int i=0; i< arr.length; i++){
            System.out.println(arr[i]+"\t");
        }
    }
}
