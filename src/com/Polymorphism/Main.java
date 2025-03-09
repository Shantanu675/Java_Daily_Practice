package com.Polymorphism;

public class Main {
    public static void main(String[] args) {
        Shapes shape = new Shapes();
        Circle circle = new Circle();
        Shapes sq = new Square();

        shape.area();
        circle.area();
        sq.area();
    }
}
