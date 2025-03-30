package LinkedList;

public class LL {

    private Node head;
    private Node tail;

    private int size;

    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        Node node = new Node(val);
        node.next = head;
        head = node;

        if(tail == null){
            tail = head;
        }
        size++;
    }

    public void insertLast(int val){
        if(tail == null) {
            insertFirst(val);
            return;
        }

        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int val, int indx){
        if(indx == 0){
            insertFirst(val);
            return;
        }
        else if(indx > size+1){
            // Hum se na ho payega .... Kisi Aur se kara lijiye !!!!!!!
            return;
        }
        else if(indx == size){
            insertLast(val);
            return;
        }

        Node node = new Node(val);
        Node temp = head;
        for (int i = 0; i < indx-1; i++) {
            temp = temp.next;
        }
        node.next = temp.next;
        temp.next = node;

        size++;
    }

    public int deleteFirst(){
        int val = head.value;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return val;
    }

    public int deleteLast(){
        if(size <= 1){
            deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        size--;
        return val;
    }

    public int delete(int indx){
        if(indx == 0){
            return deleteFirst();
        }
        else if (indx == size-1) {
            return deleteLast();
        }
        else if (indx > size) {
            return -1;
        }

        Node prev = get(indx-1);
        int val = prev.next.value;

        prev.next = prev.next.next;
        return val;
    }

    public Node find(int val){
        Node temp = head;
        while(temp != null){
            if(temp.value == val){
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Node get(int indx){
        Node temp = head;
        for (int i = 0; i < indx; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void display() {
        Node temp = head;
        while(temp != null){
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    private class Node{
        private int value;
        private Node next;

        Node(int value){
            this.value = value;
        }

        Node(int value, Node next){
            this.value = value;
            this.next = next;
        }
    }
}
