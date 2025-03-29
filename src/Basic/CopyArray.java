public class CopyArray {
    public static void main(String[] args){
        int[] arr = {12,24,36,48,60};
        int[] copy = new int[arr.length];

        for(int i=0; i<arr.length; i++){
            copy[i] = arr[i];
        }
        System.out.println("Print copy array :");

        for(int i=0; i<arr.length; i++){
            System.out.print(copy[i]+" ");
        }
    }
}
