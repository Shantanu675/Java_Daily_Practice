package LinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(90);
        System.out.println(list);

        LL l = new LL();
        l.insertFirst(91);
        l.insertFirst(1);
        l.insertFirst(24);
        l.insertFirst(46);

        l.insertLast(99);
        l.insert(34,12);

        l.deleteFirst();
        System.out.println(l.deleteLast());
        System.out.println(l.delete(2));
        System.out.println(l.delete(12));
        l.display();
    }
}
