package com.Inheritance;

public class Box {
    double length;
    double width;
    double height;

    Box (){
        this.length = -1;
        this.width = -1;
        this.height = -1;
    }

    //cude
    Box(double side){
        this.length = side;
        this.width = side;
        this.height = side;
    }

    //cuboid
    Box(double length, double width, double height){
        this.length = length;
        this.width = width;
        this.height = height;
    }

    //copy constructor
    Box(Box old){
        this.length = old.length;
        this.width = old.width;
        this.height = old.height;
    }

    public void displayInfo(){
        System.out.println("Runnig the Box");
    }
}
