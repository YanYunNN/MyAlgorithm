package easy;

import base.ListNode;

public class Q206_ReverseList {
    class Solution {
        public ListNode reverseList(ListNode head) {
            //1.itertor
         /* ListNode cur = head, prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;*/

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
}
