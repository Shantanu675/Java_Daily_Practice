package Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        CustomQueue queue = new CustomQueue();
        queue.insert(3);
        queue.insert(13);
        queue.insert(23);
        queue.insert(43);
        queue.insert(9);
        System.out.println(queue.remove());
        queue.display();
        // System.out.println(queue);
    }
}
