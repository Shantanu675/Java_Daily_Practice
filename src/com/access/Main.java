package com.access;

import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {
        A object = new A(10, "Shantanu");
//        System.out.println(object.num); // not accesible due to private
        object.setNum(35);
        System.out.println(object.getNum());
    }
}
