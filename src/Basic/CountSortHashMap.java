package Basic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CountSortHashMap {
    public static void main(String[] args) {
        int[] arr = {1,4,2,6,4,3,9,8,4,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr){
        if(arr == null || arr.length < 1){
            return;
        }

        int max = Arrays.stream(arr).max().getAsInt();
        int min = Arrays.stream(arr).min().getAsInt();

        Map<Integer, Integer> map = new HashMap<>();
        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int indx = 0;
        for (int i = min; i <= max; i++) {
            int count = map.getOrDefault(i, 0);
            for (int j = 0; j < count; j++) {
                arr[indx] = i;
                indx++;
            }
        }
    }
}
