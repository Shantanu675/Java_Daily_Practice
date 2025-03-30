package LinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
//        LinkedList<Integer> list = new LinkedList<>();
//        list.add(90);
//        System.out.println(list);
//
//        LL l = new LL();
//        l.insertFirst(91);
//        l.insertFirst(1);
//        l.insertFirst(24);
//        l.insertFirst(46);
//
//        l.insertLast(99);
//        l.insert(34,12);
//
//        l.deleteFirst();
//        System.out.println(l.deleteLast());
//        System.out.println(l.delete(2));
//        System.out.println(l.delete(12));
//        l.display();

    /* DLL li = new DLL();
    li.insertFirst(98);
    li.insertFirst(84);
    li.insertFirst(13);
    li.insertFirst(45);

    li.insertLast(99);
    //li.insert(13,77);
    li.display(); */

        CLL list = new CLL();
        list.insert(23);
        list.insert(39);
        list.insert(34);
        list.insert(13);

        list.delete(34);
        list.display();
    }
}
