package Greedy;

public class Candy {
    public static void main(String[] args) {
        int[] rating = {1,2,2};
        System.out.println(candy(rating));
    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int candies = n;

        int i = 1;
        while(i < n) {
            if (ratings[i] == ratings[i - 1]) {
                i++;
                continue;
            }

            int peak = 0;
            while (i < n && ratings[i] > ratings[i - 1]) {
                peak++;
                candies += peak;
                i++;
            }

            int valley = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                valley++;
                candies += valley;
                i++;
            }

            candies -= Math.min(peak, valley);
        }
        return candies;
    }
}
