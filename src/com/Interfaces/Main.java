package com.Interfaces;

public class Main {
    public static void main(String[] args) {
        Car car = new Car();

        System.out.println(car.a);
        car.acc();
        car.start();
        car.stop();
        car.brake();
        System.out.println(car.price);

        Media carMedia = new Car();
        carMedia.stop();

//        Engine car = new Car();
//
//        System.out.println(car.a); // not accessible
//        car.acc();
//        car.start();
//        car.stop();
//        car.brake();     // not accessible     // only that accessible which available in Engine
//        System.out.println(car.price); // accessible

        NiceCar c = new NiceCar();
        c.start();
        c.startMusic();
        c.upgradeEngine(new ElectricEngine());
        c.start();
        c.startMusic();
        c.brake();
    }
}
