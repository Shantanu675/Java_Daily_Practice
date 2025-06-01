package ThreadExamples;

class A implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Ramu");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
            }
        }
    }
}

class B implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Shamu");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
            }
        }
    }
}

class C implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Manu");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
            }
        }
    }
}

class D implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Sonu");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
            }
        }
    }
}
class E implements Runnable{
    public void run(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Ganu");
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Runnable obj1 = new A();
        Runnable obj2 = new B();
        Runnable obj3 = new C();
        Runnable obj4 = new D();
        Runnable obj5 = new E();

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        Thread t3 = new Thread(obj3);
        Thread t4 = new Thread(obj4);
        Thread t5 = new Thread(obj5);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}