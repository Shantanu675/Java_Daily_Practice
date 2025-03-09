public class EvenNumDigi {
    public static void main(String[] args) {
        int[] nums = {12,345,2,6,7896};

        int evenDigitCount = 0;

        for(int ele : nums){
            if(numDigit(ele) % 2 == 0){
                evenDigitCount++;
            }
        }
        System.out.println(evenDigitCount);
    }

    public static int numDigit(int num){
        if(num == 0){
            return 1;
        }

        if(num < 0){
            num = -1 * num;
        }

        int count = 0;

        while(num > 0){
            count++;
            num = num / 10;
        }
        return count;
    }
}
