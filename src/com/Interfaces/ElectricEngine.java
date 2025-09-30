package com.Interfaces;

public class ElectricEngine implements Engine, Break{
    @Override
    public void start(){
        System.out.println("ElectricEngine start");
    }

    @Override
    public void stop(){
        System.out.println("ElectricEngine stop");
    }

    @Override
    public void acc(){
        System.out.println("ElectricEngine acc");
    }

    @Override
    public void brake() {
        System.out.println("ElectricEngine car stops");
    }
}
