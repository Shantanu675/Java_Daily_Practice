package Basic;

public class Name{

    public static void main(String[] args){
        displayName("1");
    }

    public static void displayName(String size){
        int s = Integer.parseInt(size);
        int font = 3 + s * 2;
        System.out.println(printName(font));
    }

    public static String printName(int size){
        String str = "";
        int count=0;
        for(int row=1; row<=size; row++){
            //S
            if(row == 1){
                for(int space=1; space<=1; space++){
                    //System.out.print("  ");
                    str += "  ";
                }
                for(int sym=1; sym<=size-1; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
            }
            else if(row<= size/2){
                for(int sym=1; sym<=1; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
                for(int space=1; space<=size-1; space++){
                    //System.out.print("  ");
                    str += "  ";
                }
            }
            else if(row == size/2+1){
                for(int space=1; space<=1; space++){
                    //System.out.print("  ");
                    str += "  ";
                }
                for(int sym=1; sym<=size-2; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
                for(int space=1; space<=1; space++){
                    //System.out.print("  ");
                    str += "  ";
                }
            }
            else if(row == size){
                for(int sym=1; sym<=size-1; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
                for(int space=1; space<=1; space++){
                    //System.out.print("  ");
                    str += "  ";
                }
            }
            else{
                for(int space=1; space<=size-1; space++){
                    //System.out.print("  ");
                    str += "  ";
                }
                for(int sym=1; sym<=1; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
            }

            // H
            if(row != size/2+1){
                for(int sym=1; sym<=1; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
                for(int space=1; space<=size-2; space++){
                    //System.out.print("  ");
                    str += "  ";
                }
                for(int sym=1; sym<=1; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
            }
            else{
                for(int sym=1; sym<=size; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
            }

            //A
            if(row == size/2+1){
                for(int space=1; space<=size/2; space++){
                    //System.out.print(" ");
                    str += " ";
                }
                for(int sym=1; sym<=size; sym++){
                    //System.out.print("*");
                    str += "*";
                }
                for(int space=1; space<=size/2; space++){
                    //System.out.print(" ");
                    str += " ";
                }
            }
            else{
                for (int col = 1; col <= 2 * size - 1; col++) {
                    if (col == (2 * size - 1) / 2 + 1 - count || col == (2 * size - 1) / 2 + 1 + count) {
                        //System.out.print("*");
                        str += "*";
                    } else {
                        //System.out.print(" ");
                        str += " ";
                    }
                }
            }

            //N
            for(int sym=1; sym<=1; sym++){
                //System.out.print("* ");
                str += "* ";
            }
            for(int space=2; space<=size-1; space++){
                if(space == row){
                    //System.out.print("* ");
                    str += "* ";
                }
                else{
                    //System.out.print("  ");
                    str += "  ";
                }
            }
            for(int sym=1; sym<=1; sym++){
                //System.out.print("* ");
                str += "* ";
            }

            //T
            if(row == 1){
                for(int sym=1; sym<=size; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
            }
            else {
                for (int col = 1; col <= size; col++) {
                    if (col == size / 2 + 1) {
                        //System.out.print("* ");
                        str += "* ";
                    } else {
                        //System.out.print("  ");
                        str += "  ";
                    }
                }
            }


            //A
            if(row == size/2+1){
                for(int space=1; space<=size/2; space++){
                    //System.out.print(" ");
                    str += " ";
                }
                for(int sym=1; sym<=size; sym++){
                    //System.out.print("*");
                    str += "*";
                }
                for(int space=1; space<=size/2; space++){
                    //System.out.print(" ");
                    str += " ";
                }
            }
            else{
                for (int col = 1; col <= 2 * size - 1; col++) {
                    if (col == (2 * size - 1) / 2 + 1 - count || col == (2 * size - 1) / 2 + 1 + count) {
                        //System.out.print("*");
                        str += "*";
                    } else {
                        //System.out.print(" ");
                        str += " ";
                    }
                }
            }

            //N
            for(int sym=1; sym<=1; sym++){
                //System.out.print("* ");
                str += "* ";
            }
            for(int space=2; space<=size-1; space++){
                if(space == row){
                    //System.out.print("* ");
                    str += "* ";
                }
                else{
                    //System.out.print("  ");
                    str += "  ";
                }
            }
            for(int sym=1; sym<=1; sym++){
                //System.out.print("* ");
                str += "* ";
            }

            //U
            if(row == size){
                for(int sym=1; sym<=1; sym++){
                    //System.out.print("  ");
                    str += "  ";
                }
                for(int sym=1; sym<=size-2; sym++){
                    //System.out.print("* ");
                    str += "* ";
                }
                for(int sym=1; sym<=1; sym++){
                    //System.out.print("  ");
                    str += "  ";
                }
            }
            else{
                for(int col=1; col<=size; col++){
                    if(col == 1 || col == size){
                        //System.out.print("* ");
                        str += "* ";
                    }
                    else{
                        //System.out.print("  ");
                        str += "  ";
                    }
                }
            }

            count++;
            //System.out.println();
            str += "\n";
        }
        return str;
    }
}

