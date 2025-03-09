import java.util.Arrays;

public class SearchInMatrix {

    public static void main(String[] args) {
        int[][] arr = {{10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50}
        };
        int target = 30;
        System.out.println(Arrays.toString(findElem(arr,target)));
    }

    public static int[] findElem(int[][] arr, int target){
        int[] ans = {-1, -1};
        int row = 0;
        int col = arr.length-1;
        while(row < arr.length && col >= 0){
            if(arr[row][col] == target){
                ans[0] = row;
                ans[1] = col;
                return ans;
            }
            else if (arr[row][col] > target) {
                col--;
            }
            else{
                row++;
            }
        }
        return ans;
    }
}