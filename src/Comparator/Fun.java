package Comparator;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Student implements Comparable<Student>{
    String name;
    int age;

    Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String toString(){
        return "{" + name + " ," + age + "}";
    }

    @Override
    public int compareTo(@NotNull Student that) {
        if (this.age > that.age){
            return 1;
        }
        else{
            return -1;
        }
    }
}

public class Fun {
    public static void main(String[] args) {
        Comparator<Student> com = new Comparator<Student>() {
            @Override
            public int compare(Student i, Student j) {
                if(i.age < j.age){
                    return 1;
                }
                else{
                    return -1;
                }
            }
        };

        List<Student> stu = new ArrayList<>();
        stu.add(new Student("Jatin", 34));
        stu.add(new Student("Badoni", 25));
        stu.add(new Student("Shubhaman",28));
        stu.add(new Student("Shantanu", 20));

        Collections.sort(stu, com);
        System.out.println(stu);
    }
}
