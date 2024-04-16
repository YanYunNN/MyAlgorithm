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
            //移动+判断
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;

            //prev、start、end  next(下一块)
            ListNode start = prev.next;
            ListNode next = end.next;
            end.next = null;//防止子链表带上了反转

            prev.next = reverse(start); //先断开，再反转
            start.next = next;//这个时候start已经反转为尾节点，再相连
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

    private ListNode reverseRecursion(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
//leetcode submit region end(Prohibit modification and deletion)
}
