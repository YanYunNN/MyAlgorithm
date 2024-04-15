package zhard;

import base.ListNode;

public class Q25_reverseKGroup {
    //leetcode submit region begin(Prohibit modification and deletion)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = prev;

        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;//防止子链表带上了反转

            prev.next = reverse(start);
            start.next = next;
            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
//leetcode submit region end(Prohibit modification and deletion)
}
