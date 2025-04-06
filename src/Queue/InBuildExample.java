package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class InBuildExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(3);
        queue.add(13);
        queue.add(23);
        queue.add(43);
        queue.clear();
        System.out.println(queue.poll());
        System.out.println(queue);
       // System.out.println(queue);
    }

}
