package com.Shantanu.staticEx;

public class StaticBlock {
    static int a = 4;
    static int b;

    static {
        System.out.println("I am in static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock obj1 = new StaticBlock();
        System.out.println(StaticBlock.b);
    }
}
