import java.util.Arrays;

public class NintyDeegree {
    public static void main(String[] args) {
        int[][] matrix = {{7, 8, 9},
                {4, 5, 6},
                {1, 2, 3}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        int[][] arr = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = matrix[matrix.length - 1 - j][i];
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}