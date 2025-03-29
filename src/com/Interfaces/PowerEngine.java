package com.Interfaces;

public class PowerEngine implements Engine{

    @Override
    public void start(){
        System.out.println("PowerEngine start");
    }

    @Override
    public void stop(){
        System.out.println("PowerEngine stop");
    }

    @Override
    public void acc(){
        System.out.println("PowerEngine acc");
    }
}
