public class Linear {
    public static void main(String[] args) {
        int[] arr = {12,16,3,7,26,35};

        int target = 15;

        if(lenearSearch(arr,target)){
            System.out.println("Present");
        }else{
            System.out.println("Not Present");
        }

        String name = "Kunal";

        char tar = 'n';

        if(search(name,tar)){
            System.out.println("Present");
        }else{
            System.out.println("Not Present");
        }
    }

    public static boolean lenearSearch(int[] arr, int target){
        for(int ele : arr){
            if(ele == target){
                return true;
            }
        }
        return false;
    }

    public static boolean search(String name, char target){
        for(char ele : name.toCharArray()){ //convert string into char array
            if(ele == target){
                return true;
            }
        }
        return false;
    }
}
