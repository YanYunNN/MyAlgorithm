package medium;

import base.ListNode;

public class Q086_partition {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);

        ListNode p = head, p1 = dummy1, p2 = dummy2;
        while (p != null) {
            if (p.val < x) {
                p1.next = p;
                p1 = p1.next;
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            ListNode temp = p.next;
            p.next = null;
            p = temp;
            // p = p.next; 不断链会产生环
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }
}
