package Queue;

public class CircularQueueMain {
    public static void main(String[] args) throws Exception{
        CircularQueue cq = new CircularQueue(5);

        cq.insert(5);
        cq.insert(15);
        cq.insert(12);
        cq.insert(34);
        //cq.insert(29);
        System.out.println(cq.remove());
        cq.insert(134);
        cq.insert(92);
        System.out.println(cq.insert(84));
        cq.display();
        System.out.println(cq.front());
    }
}
