public class NextGreatestLetter {
    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        char target = 'g';

        System.out.println(nextGreatestLetter(arr,target));
    }
    public static char nextGreatestLetter(char[] arr, char target){
        //when target is smaller than end(largest) char in an array -> return first char in an array
        //(Letter wrap around)
//        if(target >= arr[arr.length-1]){
//            return arr[0];
//        }

        int start = 0;
        int end = arr.length-1;

        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        //Think about this
        //when target is smaller than end(largest) char in an array
        //start go one step forward than {arr[arr.length-1]} means last element (whole array)
        //so we can easily apply mod to get one
        return arr[start% arr.length];
//        return arr[start];
    }
}
