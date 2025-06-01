package FileHandling;

import java.io.*;

public class Main {
    public static void main(String[] args){
//        try(InputStreamReader isr = new InputStreamReader(System.in)){
//            System.out.println("Enter some letters: ");
//            int letters = isr.read();
//            while(isr.ready()) {
//                System.out.println((char) letters);
//                letters = isr.read();
//            }
////            System.out.println();
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }

//        try(FileReader fr = new FileReader("note.txt")){
//            int letters = fr.read();
//            while(fr.ready()) {
//                System.out.println((char) letters);
//                letters = fr.read();
//            }
////            System.out.println();
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }

//        try(BufferedReader br  = new BufferedReader(new InputStreamReader(System.in))){
//            System.out.println("You typed  => " + br.readLine());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
////
//        try(BufferedReader br  = new BufferedReader(new FileReader("note.txt"))){
//            System.out.println("You typed  => " + br.readLine());
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

//        try(OutputStreamWriter osw = new OutputStreamWriter(System.out)){
//            osw.write("Hello World");
//            osw.write(97);
//            osw.write(10);
//            osw.write('A');
//            osw.write('\n');
//            char[] arr = "hello world".toCharArray();
//            osw.write(arr);
//            //for imogi range exceed
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
        try(FileWriter fr = new FileWriter("note.txt",true)){
            fr.write("Hello World");
            //for imogi range exceed
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("note.txt",true))){
            bw.write("Hare Krishna");
            //for imogi range exceed
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}