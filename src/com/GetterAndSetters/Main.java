package com.GetterAndSetters;

class Human{
    private int age;
    private String name;

    public void setAge(int age){
        this.age = age;
    }

    int getAge(){
        return this.age;
    }

    void setName(String name){
        this.name = name;
        // this.name object => current obj var
        // name => local var
    }

    String getName(){
        return this.name;
    }
}

public class Main {
    public static void main(String[] args) {
        Human human = new Human();
        //human.setAge(90);
        System.out.println(human.getAge()); // provide default value
        System.out.println(human.getName());
    }
}