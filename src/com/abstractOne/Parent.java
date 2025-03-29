package com.abstractOne;

public abstract class Parent {

    int age;

    public Parent(int age){
        this.age = age;
    }

    static void mesg(){
        System.out.println("Hello");
    }

    void normal(){
        System.out.println("This is normal method");
    }

    abstract void career();
    abstract void partner();
}
