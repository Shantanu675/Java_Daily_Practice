package com.Sigleton;

import com.access.A;

public class Subclass extends A {
    public Subclass(int num, String name){
        super(num, name);
    }

    public static void main(String[] args) {
        Subclass obj = new Subclass(45, "SHANTANU10");
        System.out.println(obj.num);
    }
}