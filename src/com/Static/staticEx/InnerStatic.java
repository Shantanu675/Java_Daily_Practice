package com.Static.staticEx;
//  +-----------------------------------------------+
//  |    What is use of inner class see kk video    |
//  +-----------------------------------------------+
public class InnerStatic {
     static class Test{
        String name;

        public Test(String name){
            this.name = name;
        }

        public String toString() {
             return name+ "////";
         }
     }

    public static void main(String[] args) {
        Test a = new Test("Shantanu");
//        System.out.println(Test.name);
        Test b = new Test("Rahul");

        System.out.println(a);

        System.out.println(a.name);//shantanu
        System.out.println(b.name);//rahul
        //also depend where static is use
    }
}

//class Test{
//    static String name;
//
//    public Test(String name){
//        this.name = name;
//    }
//}

//static class A{
//
//}