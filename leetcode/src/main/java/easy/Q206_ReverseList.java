package easy;

import base.ListNode;

public class Q206_ReverseList {
    public ListNode reverseList1(ListNode head) {
        //itertor
        ListNode prev = null, cur = head, next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    public ListNode reverseList(ListNode head) {
        //recursion
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null; //否则会回环
        return newHead;
    }
}
