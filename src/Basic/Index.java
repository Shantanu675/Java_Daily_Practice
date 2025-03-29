//I solve this question by linear search approach
public class Index{

    public static void main(String[] args){
        int[] arr = {12,24,36,48,60};

        int num = 36;

        System.out.println("The Index of "+ num +" is " + findIndx(arr, num));
    }

    public static int findIndx(int[] arr, int num){
        for(int i=0; i<arr.length; i++){
            if(arr[i] == num){
                return i;
            }
        }
        return -1;
    }
}
