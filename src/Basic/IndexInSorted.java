//To solve this question I use Binary search approach
public class IndexInSorted{

    public static void main(String[] args){
        int[] arr = {12,24,36,48,60};

        int num = 48;

        System.out.println("The Index of "+ num +" is " + binaryIndx(arr, num));
    }

    public static int binaryIndx(int[] arr, int num){
        int small = 0;
        int large = arr.length-1;

        while(large > small){
            int mid = (large + small)/2;

            if(arr[mid] == num){
                return mid;
            }

            else{

                if(arr[mid] > num){
                    large = mid-1;
                }

                else{
                    small = mid+1;
                }

            }
        }
        return -1;
    }
}
