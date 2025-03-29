package com.abstractOne;

public class Main {
    public static void main(String[] args) {
        Son son = new Son(67);
        son.career();
        System.out.println(son.age);
        son.normal();

        Daughter daughter = new Daughter(8);
        daughter.career();
        System.out.println(daughter.age);

//        Parent parent = new Parent();
        Parent.mesg();
    }
}
