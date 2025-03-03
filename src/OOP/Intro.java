package OOP;

import java.util.Arrays;

public class Intro {
    public static void main(String[] args) {
//        int[] rno = new int[5];
//
//        String[] name = new String[5];
//
//        int[] rno1 = new int[5];
//        String[] name1 = new String[5];
//        float[] marks = new float[5];
        Student[] stu = new Student[5];

//        Student kunal;
////        System.out.println(kunal);
//        System.out.println(Arrays.toString(stu));

//        Student kunal = new Student();
//        System.out.println(kunal);
//        System.out.println(kunal.rno);
//        System.out.println(kunal.name);
//        System.out.println(kunal.marks);

        Student kunal = new Student();
        System.out.println(kunal);
        kunal.changeName("Krushna");
        kunal.greeting();

        //        local variable get more advantage
        kunal.rno = 1;
        kunal.name = "Kunal Kushwah";

        kunal.changeName("Shoe Lover");
        kunal.greeting();
        //kunal.marks = 34.7F;
        System.out.println(kunal.rno);
        System.out.println(kunal.name);
        System.out.println(kunal.marks);// if default value is given then use that (but first preference go to local one)

        Student rahul = new Student(100, "Rahul", 65);
        System.out.println(rahul.rno);
        System.out.println(rahul.name);
        System.out.println(rahul.marks);

        Student random = new Student(kunal);
        System.out.println(random.rno);
        System.out.println(random.name);
        System.out.println(random.marks);

        Student random2 = new Student();
        System.out.println(random2.rno);
        System.out.println(random2.name);
        System.out.println(random2.marks);
    }
}

class Student{
    Student(){
//        this.rno = 12;
//        this.name = "Kun Kushwah";
//        this.marks = 347F;
        // internally it is like : new Student(200,"anonymous",4569.4)
        this(200,"anonymous",49.4F);
    }

    //Right(Same variable names)
    Student(int rno, String name, float marks){
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    //Also Right (different variable names)
//    Student(int roll, String naam, float ma){
//        rno = roll;
//        name = naam;
//        marks = ma;
//    }

    Student(Student other){
        this.rno = other.rno;
        this.name = other.name;
        this.marks = other.marks;
    }

    void greeting(){
//        System.out.println("Hello my name is "+name);
        System.out.println("Hello my name is "+this.name);
    }

    void changeName(String name){
        this.name = name;
    }

    int rno;
    String name;
    float marks = 90F;
}
