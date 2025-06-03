package Basic;

public class RangeQuery {
    public static void main(String[] args) {
        int[] arr = {1,5,3,7,8,4,5,2,6,8};
        int sqrt = (int)Math.sqrt(arr.length);

        int[] block = new int[sqrt+1];
        int blockIndex = -1;
        for(int i = 0; i < arr.length; i++){
            if(i % sqrt == 0){
                blockIndex++;
            }
            block[blockIndex] += arr[i];
        }
        //--------------------------------------------
        int sum = sumQuery(block, arr, 2,7,sqrt);

        System.out.println(sum);
        //---------------update----------------------
        update(block, arr, 7,4,3);
        int sum2 = sumQuery(block, arr, 2,7,sqrt);

        System.out.println(sum2);
    }

    public static int sumQuery(int[] block, int[] arr, int l, int r, int sqrt){
        int sum = 0;

        while(l%sqrt != 0 && l < r && l != 0){
            sum += arr[l];
            l++;
        }

        while(l + sqrt < r){
            sum += block[l / sqrt];
            l += sqrt;
        }

        while(l <= r){
            sum += arr[l];
            l++;
        }
        return sum;
    }

    public static void update(int[] block, int[] arr, int newVal, int index, int sqrt){
        block[index / sqrt] += (newVal - arr[index]);
        arr[index] = newVal;
    }
}
