public class EvenOdd{

    public static void main(String[] args){
        int[] arr = {12,15,24,30,36,45};

        int even = totalEvenElements(arr);
        System.out.println("Number even Elements in arr is "+ even);
        System.out.println("Number odd Elements in arr is "+ (arr.length-even));
    }

    public static int totalEvenElements(int[] arr){
        int even = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]%2 == 0){
                even++;
            }
        }
        return even;
    }
}
