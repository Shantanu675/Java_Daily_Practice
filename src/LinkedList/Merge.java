package LinkedList;

import org.w3c.dom.Node;

public class Merge {

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode middle = middle(head);
        ListNode left = sortList(head);
        ListNode right = sortList(middle);

        return merge(left, right);
    }

    public ListNode merge(ListNode list1, ListNode list2){
        ListNode temp1 = list1;
        ListNode temp2 = list2;

        ListNode dHead = new ListNode();
        ListNode ansNode = dHead;
        while(temp1 != null && temp2 != null) {
            if (temp1.val < temp2.val) {
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

    public ListNode middle(ListNode head){
        ListNode fast = head;
        ListNode slow = null;

        while(fast != null && fast.next != null){
            slow = (slow == null) ? head : slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        slow.next = null;

        return mid;
    }

}
