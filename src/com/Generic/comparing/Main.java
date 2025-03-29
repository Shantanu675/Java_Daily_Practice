package com.Generic.comparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student shantanu = new Student(51,97.6f);
        Student rahul = new Student(52,90.96f);
        Student arpit = new Student(50,77.6f);
        Student kunal = new Student(53,80.96f);
        Student aahan = new Student(55,67.6f);
        Student Aakay = new Student(46,60.96f);

        Student[] list = {shantanu, rahul, arpit, kunal, aahan, Aakay};
        System.out.println(Arrays.toString(list));
        //Arrays.sort(list);
        /* Arrays.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int)(o1.rollno - o2.rollno);
                //we can use mark in place of rollno when we want sorting by marks
            }
        }); */

        //lambda equation
        Arrays.sort(list, (o1,o2) -> (int)(o1.rollno - o2.rollno));
        System.out.println(Arrays.toString(list));


//        if(shantanu.compareTo(rahul) > 0){
//            System.out.println(shantanu.compareTo(rahul));
//            System.out.println("shantanu has more marks");
//        }
    }
}
