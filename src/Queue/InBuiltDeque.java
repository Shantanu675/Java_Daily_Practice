package Queue;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayDeque;
import java.util.Deque;

public class InBuiltDeque {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(3);
        deque.add(23);

        System.out.println(deque.offerLast(13));// insert last
        System.out.println(deque);

    }
}
