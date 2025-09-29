package OOP;

public class Intro2 {
    public static void main(String[] args) {
        Student1 kunal = new Student1(12, "kunal", 76.89f);
        kunal.greeting();
        kunal.changeName("chota bheem");
        System.out.println(kunal.name);

        Student1 krishna = new Student1(13, "krishna", 46.99f);
        krishna.greeting();

//        Student1 kk;           // must assign null otherwise throw compile time Error
//        System.out.println(kk);
    }
}

class Student1{

    //Right(Same variable names)
    Student1(int rno, String name, float marks){
        this.rno = rno;
        this.name = name;
        this.marks = marks;
    }

    Student1(Student other){
        this.rno = other.rno;
        this.name = other.name;
        this.marks = other.marks;
    }

    void greeting(){
//        System.out.println("Hello my name is "+name);
        System.out.println("Hello my name is "+name);
    }

    void changeName(String name){
        name = name;
    }

    int rno;
    String name;
    float marks = 90F;
}
