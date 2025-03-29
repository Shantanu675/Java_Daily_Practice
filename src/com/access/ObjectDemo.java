package com.access;

public class ObjectDemo{

    int num;

    public ObjectDemo(int num) {
        this.num = num;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.num == ((ObjectDemo)obj).num;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static void main(String[] args) {
        ObjectDemo obj = new ObjectDemo(45);
        ObjectDemo obj1 = obj;
        System.out.println(obj.hashCode());
        System.out.println(obj1.hashCode());

        if(obj == obj1){
            System.out.println("obj is equal to obj1:");
        }

        if(obj.equals(obj1)){
            System.out.println("obj is equal to obj1?");
        }

        System.out.println(obj instanceof ObjectDemo);
    }
}
