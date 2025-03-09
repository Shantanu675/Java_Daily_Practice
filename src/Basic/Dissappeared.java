import java.util.*;

public class Dissappeared {
    public static void main(String[] args) {
        int arr[] = {4,3,2,7,8,2,3,1};

        List<Integer> list = findDisappearedNumbers(arr);
        for(int indx = 0; indx < list.size(); indx++){
            System.out.println(list.get(indx));
        }
    }

    public static List<Integer> findDisappearedNumbers(int[] arr) {
        List<Integer> list = new ArrayList<>();

        int i = 0;
        while(i < arr.length){
            if(arr[i] == i+1 || arr[i] == arr[arr[i]-1]){
                i++;
            }
            else{
                swap(arr, i, arr[i]-1);
            }
        }

        for(int indx = 0; indx < arr.length; indx++){
            if(arr[indx] != indx+1){
                list.add(indx+1);
            }
        }
        return list;
    }

    public static void swap(int[] arr, int first, int last){
        int temp = arr[first];
        arr[first] = arr[last];
        arr[last] = temp;
    }
}
