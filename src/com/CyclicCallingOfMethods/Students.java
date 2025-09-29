// Stack overflow

package com.CyclicCallingOfMethods;

public class Students {
    public Students() {
        System.out.println("Constructor");
    }

    public static void main(String[] args) {
        Students s = new Students();
        s.fun();
    }

    public void fun() {
        System.out.println("fun");
        fun2();
    }

    public static void fun2() {
        System.out.println("fun2");
        Students s = new Students();
        s.fun();
    }

//    public static void fun3() {
//        System.out.println("fun3");
//        fun2();
//    }
}
