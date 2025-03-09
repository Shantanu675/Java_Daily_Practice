import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr = {1,4,13,6,7,13,16,9,13};
        System.out.println(indexLinearSearch(arr,9,0));
        System.out.println(linearSearch(arr,9,0));
        indexAllLinearSearch(arr, 13, 0);
        System.out.println(list);

        ArrayList<Integer> ans = listIndexAllLinearSearch(arr, 13, 0, new ArrayList<>());
        System.out.println(ans);

        ArrayList<Integer> newAns = listFindIndexAllLinearSearch(arr, 13, 0);
        System.out.println(newAns);
    }

    public static boolean linearSearch(int[] arr, int target, int indx){
        if(indx == arr.length-1 && arr[indx] != target){
            return false;
        }
        if(arr[indx] == target){
            return true;
        }

        return linearSearch(arr,target,indx+1);

//        if(indx == arr.length){
//            return false;
//        }
//        return arr[indx] == target || linearSearch(arr, target, indx-1);
    }

    public static int indexLinearSearch(int[] arr, int target, int indx) {
        if (indx == arr.length) {
            return indx;
        }
        if (arr[indx] == target) {
            return indx;
        }
        return indexLinearSearch(arr, target, indx + 1);
    }

    static ArrayList<Integer> list = new ArrayList<>();

    public static void indexAllLinearSearch(int[] arr, int target, int indx) {
        if (indx == arr.length) {
            return;
        }
        if (arr[indx] == target) {
            list.add(indx);
        }
        indexAllLinearSearch(arr, target, indx+1);
    }

    public static ArrayList<Integer> listIndexAllLinearSearch(int[] arr, int target, int indx, ArrayList<Integer> list) {
        if (indx == arr.length) {
            return list;
        }
        if (arr[indx] == target) {
            list.add(indx);
        }
        return listIndexAllLinearSearch(arr, target, indx + 1, list);
    }

    public static ArrayList<Integer> listFindIndexAllLinearSearch(int[] arr, int target, int indx) {
        ArrayList<Integer> list = new ArrayList<>();

        if (indx == arr.length) {
            return list;
        }
        if (arr[indx] == target) {
            list.add(indx);
        }

        ArrayList<Integer> ansFromBelowCall = listFindIndexAllLinearSearch(arr, target, indx+1);

        list.addAll(ansFromBelowCall);
        return list;
    }
}
