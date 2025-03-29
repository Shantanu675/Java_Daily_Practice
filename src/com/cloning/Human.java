package com.cloning;

public class Human implements Cloneable {
    int age;
    String name;
    int[] arr;

    public Human(int age, String name){
        this.age = age;
        this.name = name;
        this.arr = new int[]{3,4,5,6,9,1};
    }

    public Human(Human other){
        this.age = other.age;
        this.name = other.name;
    }

//    @Override
//    //Shallow copy
//    public Object clone() throws CloneNotSupportedException{
//        return super.clone();
//    }

    @Override
    //Deep copy
    public Object clone() throws CloneNotSupportedException{
        Human twin =  (Human)super.clone(); //this is actually shallow copy

        //make a deep copy
        twin.arr = new int[twin.arr.length];
        for (int i = 0; i < twin.arr.length; i++) {
            twin.arr[i] = this.arr[i];
        }
        return twin;
    }
}
