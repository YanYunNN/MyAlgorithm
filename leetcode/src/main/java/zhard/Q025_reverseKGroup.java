package zhard;

import base.ListNode;

/**
 * @author xin_cai
 * @date 2024/04/15
 * @see <a href='https://leetcode.cn/problems/reverse-nodes-in-k-group/solutions/10416/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t'/>解法<a/>
 */
public class Q025_reverseKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            //移动+判断
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;

            //prev、start、end  next(下一块)
            ListNode start = prev.next;
            ListNode next = end.next;

            //先断开，再反转
            end.next = null;
            prev.next = reverse(start);
            start.next = next; //这个时候start已经反转为尾节点，再相连

            prev = start;
            end = prev;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

}
