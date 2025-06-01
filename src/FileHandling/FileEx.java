package FileHandling;

import java.io.*;

public class FileEx {
    public static void main(String[] args) {
        //create
        try {
            File f = new File("Demo.txt");
            f.createNewFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //write
        try(FileWriter fr = new FileWriter("Demo.txt",true)){
            fr.write("AnyThing");
            //for imogi range exceed
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        //read
        try(BufferedReader fr = new BufferedReader(new FileReader("Demo.txt"))){
            int letters = fr.read();
            while(fr.ready()) {
                System.out.println((char) letters);
                letters = fr.read();
            }
//            System.out.println();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }

        //create
        try {
            File f = new File("random.txt");
            f.createNewFile();
            //delete file
            if(f.delete()){
                System.out.println(f.getName());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
