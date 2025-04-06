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

    // insertion using reccursion
    public void insertRec(int val, int index){
        head = insertRec(val, index, head);
    }

    private Node insertRec(int val, int indx, Node node){
        if(indx == 0){
            Node temp = new Node(val, node);
            size++;
            return temp;        }
        node.next = insertRec(val, indx--, node.next);
        return node;
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

    // remove duplicates
    public void rem_dup(){
        Node temp = head;

        while(temp.next != null){
            if(temp.value == temp.next.value){
                temp.next = temp.next.next;
                size--;
            }
            else{
                temp = temp.next;
            }
        }

        return;
    }

    // Merge two sorted LL
    public Node merge(Node list1, Node list2){
        Node temp1 = list1;
        Node temp2 = list2;

        //LL ans = new LL();
        Node dHead = new Node(0);
        Node ansNode = dHead;
        while(temp1 != null && temp2 != null) {
            if (temp1.value < temp2.value) {
                dHead.next = temp1;
                temp1 = temp1.next;
                dHead = dHead.next;
            } else {
                dHead.next = temp2;
                temp2 = temp2.next;
                dHead = dHead.next;
            }
        }

        if(temp1 != null){
            dHead.next = temp1;
        }
        if(temp2 != null){
            dHead.next = temp2;
        }
        return dHead;
    }

    // check cycle in linked list
    public boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    // length of cycle in linked list
    public int lengthCycle(Node head) {
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast){
                Node temp = slow;
                int len = 0;
                do{
                    temp = temp.next;
                    len++;
                }while(slow.value != temp.value);
                return len;
            }
        }
        return 0;
    }

    //detect from where cycle is starts
    public Node detectCycle(Node head) {
        Node fast = head;
        Node slow = head;
        int length = 0;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                length = lengthCycle(head);
                break;
            }
        }

        if(length == 0){
            return null;
        }

        Node f = head;
        Node s= head;
        while(length > 0){
            s = s.next;
            length--;
        }

        while(f != s){
            s = s.next;
            f = f.next;
        }
        return s;
    }

    //Happy number problem
    public int findSquareSum(int num){
        int sum = 0;
        while(num > 0){
            int rem = num % 10;
            sum += rem * rem;
            num /= 10;
        }
        return sum;
    }

    public boolean isHappy(int n) {
        int fast = n;
        int slow = n;

        do{
            slow = findSquareSum(n);
            fast = findSquareSum(findSquareSum(n));
        }while (slow != fast);

        if(slow == 1){
            return true;
        }

        return false;
    }

    // find middle node
    public Node middle(Node head){
        Node fast = head;
        Node slow = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // merge sort
    public Node sorted(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node middle = middle(head);
        Node left = sorted(head);
        Node right = sorted(middle);

        return merge(left, right);
    }

    //Bubble sort
    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }

    private void bubbleSort(int row, int col) {
        if (row == 0) {
            return;
        }

        if (col < row) {
            Node first = get(col);
            Node second = get(col + 1);

            if (first.value > second.value) {
                // swap
                if (first == head) {
                    head = second;
                    first.next = second.next;
                    second.next = first;
                } else if (second == tail) {
                    Node prev = get(col - 1);
                    prev.next = second;
                    tail = first;
                    first.next = null;
                    second.next = tail;
                } else {
                    Node prev = get(col - 1);
                    prev.next = second;
                    first.next = second.next;
                    second.next = first;
                }
            }
            bubbleSort(row, col + 1);
        } else {
            bubbleSort(row - 1, 0);
        }
    }

    // recursive reverse LL
    public void reverse(Node node) {
        if(node == tail){
            head = tail;
            return;
        }
        reverse(node.next);
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // in-place reverse
    public Node reverseInPlace(Node node) {
        if(head == null || head.next == null){
            return head;
        }

        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    //palindrome or not LL
    public boolean isPalindrome(Node head){
        Node mid = middle(head);
        Node rev = reverseInPlace(mid);

        Node ptr1 = head;
        Node ptr2 = rev;

        while(ptr2.next != null){
            if(ptr1.value != ptr2.value){
                return false;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return true;
    }

    //Reorder 1-4-2-3
    public void reorderList(Node head) {
        if(head == null || head.next == null){
            return;
        }

        Node mid = middle(head);

        Node ptr1 = head;
        Node ptr2 = reverseInPlace(head);

        while(ptr1 != null && ptr2 != null){
            Node temp = ptr1.next;
            ptr1.next = ptr2;
            ptr1 = temp;

            temp = ptr2.next;
            ptr2.next = ptr1;
            ptr2 = temp;
        }

        if(ptr1 != null){
            ptr1.next = null;
        }
    }

    //from ChatGPT
    public void reorderList1(Node head) {
        if(head == null || head.next == null){
            return;
        }

        // Step 1: Find the middle of the list
        Node mid = middle(head);

        // Step 2: Reverse the second half
        Node ptr2 = reverseInPlace(mid.next);
        mid.next = null; // disconnect the first half from the second half

        // Step 3: Merge the two halves
        Node ptr1 = head;

        while (ptr1 != null && ptr2 != null) {
            Node temp1 = ptr1.next;
            Node temp2 = ptr2.next;

            // Reorder pointers
            ptr1.next = ptr2;
            ptr2.next = temp1;

            // Move to the next pair of nodes
            ptr1 = temp1;
            ptr2 = temp2;
        }

        // if(ptr1 != null){
        //     ptr1.next = null;
        // }
    }


}

