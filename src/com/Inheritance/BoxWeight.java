package com.Inheritance;

public class BoxWeight extends Box{
    double weight;

    public BoxWeight(){
        this.weight = -1;
    }

    public BoxWeight(BoxWeight other){
        other.weight = -1;
    }

    public BoxWeight(double length, double width, double height, double weight){
        super(length, width, height); // what is this --> call the parent classs constructor
        System.out.println(this.width);
        System.out.println(super.width);
        this.weight = weight;
    }

    public BoxWeight(double side, double weight){
        super(side); // what is this --> call the parent classs constructor
        this.weight = weight;
    }
}