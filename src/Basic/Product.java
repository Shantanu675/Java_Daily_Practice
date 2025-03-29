public class Product{

    public static void main(String[] args){
        int[] arr = {12,24,10,48,6};

        System.out.println("Array Product = "+ arrPro(arr));
    }

    public static int arrPro(int[] arr){
        int pro = 1;
        for(int i=0; i<arr.length; i++){
            pro = pro * arr[i];
        }
        return pro;
    }
}
