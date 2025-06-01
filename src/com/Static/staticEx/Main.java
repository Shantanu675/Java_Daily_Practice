package com.Static.staticEx;

public class Main {
    public static void main(String[] args) {
        Human shantanu = new Human(20, "Shantanu Danej", 0, false);
        System.out.println(shantanu.population); // 1 (only one human is created till now)
        System.out.println(Human.population);// right
//        System.out.println(rahul.population); // no rahul object created till now


        Human rahul = new Human(23, "Rahul Kumar", 10000, true);

        System.out.println(shantanu.name);
        System.out.println(shantanu.population);// 2 for all human population is constant because static
        System.out.println(Human.population);// right (warning remove)
        System.out.println(rahul.population); // 2

//        fun();
    }

    // this is not dependent on object
    static void fun(){
        //Main sc = new Main();
       // /*sc.*/greeting();// required an instance// greeting : i want object i am non-static
                                                   // fun     : i don't have object you will not run give error
    }

    void fun2(){
        //inside non-static we can call non-static
        greeting(); // greeting : i want object i am non-static
                    // fun2     : i have object use my object
    }

    //we know, something which is non-static, belong to object
    //this is have instance
    void greeting(){
//        fun();
        System.out.println("Hi, Shantanu");
    }
}
