package com.Generic.comparing;


public class Student implements Comparable<Student> {
    int rollno;
    float marks;

    Student(int rollno, float marks){
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o){
       int diff = (int)(this.marks - o.marks);
//       if diff == 0  then, both are equal
//       if diff is -ve then, this obj is less atribute than other one
       return diff;
    }

    @Override
    public String toString(){
        return marks+" "+rollno;
    }

}
