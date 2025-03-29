//Second Largest Without Sorting
public class SecLargest {
    
    public static void main(String[] args){
        int[] arr = {3, 12, 6, 15, 9, 18};

        System.out.println("Second Largest = "+ secLarge(arr));
    }

    public static int secLarge(int[] arr){
        if(arr.length < 2){
            System.out.println("No Second lasrgest Element possible");
            return 0;
        }

        int largest = Integer.MIN_VALUE;
        int secLarge = arr[0];

        for(int i = 0; i<arr.length; i++){
            if(arr[i] > largest){
                secLarge = largest;
                largest = arr[i];
            }
        }
        return secLarge;
    }
}