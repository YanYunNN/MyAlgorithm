package easy;

import base.ListNode;

public class Q141_cycleLinkedList {
    public boolean hasCycle(ListNode head) {
        ListNode l1 = head, l2 = head;
        while (l2 != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next.next;
            if (l1 == l2) return true;
        }
        return false;
    }
}
