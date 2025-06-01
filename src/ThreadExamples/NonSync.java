package ThreadExamples;

class Counter{
    int count;
    public synchronized int increase(){
        return count++;
    }
}

public class NonSync {
    public static void main(String[] args) throws InterruptedException {
        Counter c = new Counter();
        Runnable obj1 = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(c.increase());
            }
        };

        Runnable obj2 = () -> {
            for (int i = 0; i < 10000; i++) {
                System.out.println(c.increase());
            }
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj1);

        t1.run();
        t2.run();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}
