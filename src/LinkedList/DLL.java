package LinkedList;

public class DLL {
     private Node head;
     private Node tail;

     private int size;

     public DLL(){
         this.size = 0;
     }

     public void insertFirst(int val){
         Node node = new Node(val);
         node.next = head;
         node.prev = null;
         if(head != null) {
             head.prev = node;
         }
         head = node;

         size++;
     }

     public void insertLast(int val){
         Node node = new Node(val);
         Node last = head;

         if(head == null){
             node.prev = null;
             head = node;
             return;
         }

         while (last.next != null){
             last = last.next;
         }

         last.next = node;
         node.prev = last;
     }

     public void  insert(int after, int val){
         Node p = find(val);

         if(p == null){
             System.out.println("Does not exist");
         }

         Node node = new Node(val);
         node.next = p. next;
         p.next = node;
         node.prev = p;
         if(node.next != null) {
             node.next.prev = node;
         }
     }

     public void display(){
         Node temp = head;
         Node last = null;
         while(temp != null){
             System.out.print(temp.value + " => ");
             last = temp;
             temp = temp.next;
         }
         System.out.println("End");

         System.out.println("Print in Reverse");
         while(last != null){
             System.out.print(last.value + " => ");
             last = last.prev;
         }
         System.out.println("End");
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

    private class Node{
        private int value;
        private Node next;
        private Node prev;

        private Node(int value){
            this.value = value;
        }

        private Node(int value, Node next, Node prev){
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
