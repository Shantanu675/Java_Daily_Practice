package com.Krishna;

class A{
    A(int a){
        this();
        System.out.println("in A int");
    }
    A(){
        System.out.println("in A");
    }
}

class B extends A{
    B(){
        System.out.println("in B");
    }
    B(int a){
        super(9);
        System.out.println("in B int");
    }
}
public class Example {
    public static void main(String[] args) {
        B c = new B(8);
    }
}
