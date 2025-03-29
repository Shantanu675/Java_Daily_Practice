public class Maze {

    public static void main(String[] args) {
        System.out.println(countPath(3,3));
    }

    public static int countPath(int row, int col){
        if(row == 1 || col == 1){
            return 1;
        }
        int paths = 0;

        paths = paths + countPath(row-1, col);
        paths = paths + countPath(row, col-1);
        return paths;
    }
    
}
