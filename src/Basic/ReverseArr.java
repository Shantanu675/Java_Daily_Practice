public class ReverseArr{

    public static void main(String[] args){
        int[] arr = {12,24,36,48,60};

        System.out.println("Reverse array :");
        totalElements(arr);
    }

    public static void totalElements(int[] arr){
        for(int i=arr.length-1; i>0; i--){
            System.out.print(arr[i]+" ");
        }
    }
}
