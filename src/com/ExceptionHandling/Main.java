package com.ExceptionHandling;

public class Main {
    public static void main(String[] args) {
        int a = 5;
        int b = 0;
        try {
            divide(a,b);
//            int c = a / b;
        } catch (ArithmeticException e){
            System.out.println(e);
            System.out.println(e.getMessage());
            System.out.println("/ by zero");
        } catch (Exception e){

        } finally {
            System.out.println("this will always execute");
        }
    }
//public static void main(String[] args) {
//    int a = 5;
//    int b = 0;
//    try {
//        divide(a,b);
////            int c = a / b;
//    } catch (Exception e){
//        System.out.println(e);
//        System.out.println(e.getMessage());
//        System.out.println("/ by zero");
//    } catch (ArithmeticException e){
//        System.out.println("Strinct exception");
//    } finally {
//        System.out.println("this will always execute");
//    }
//}a




//    //Strict exception must be write first''''''''''''''''''''''
//
////    static int divide (int a, int b){
////        return a/b;
////    }

    static int divide (int a, int b) throws Exception{
        if(b == 0){
            throw new Exception();
        }
        return a/b;
    }
}
