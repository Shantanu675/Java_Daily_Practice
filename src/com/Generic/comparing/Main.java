package com.Generic.comparing;

public class Main {
    public static void main(String[] args) {
        Student stu1 = new Student(10, 90.8f);
        Student stu2 = new Student(23, 95.4f);

        System.out.println(stu1);
        System.out.println(stu2);

        System.out.println(stu1.compareTo(stu2));
    }
}
