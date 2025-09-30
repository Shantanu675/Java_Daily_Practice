package com.Interfaces.ExtendsDemo;

public class Main implements A,B{
    @Override
    public void fun(){
        System.out.println("Hello");
    }

    @Override
    public void greet(){
        System.out.println("Hey");
    }

    public static void main(String[] args) {
        A a = new Main();
//        b.greet();   // not possible
        A.getStr();
    }
}
