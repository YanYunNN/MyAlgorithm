package medium;

import base.ListNode;

/**
 * @author: xcai
 * @date: 2024/05/15
 * @see <a href='https://labuladong.online/algo/essential-technique/linked-list-skills-summary-2/#%E5%88%A4%E6%96%AD%E9%93%BE%E8%A1%A8%E6%98%AF%E5%90%A6%E5%8C%85%E5%90%AB%E7%8E%AF'>Conf<a/>
 */
public class Q142_linkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) break;//相遇了需要进一步判断
        }
        if (fast == null || fast.next == null) {
            return null; //fast=slow=null 或者他们的next=null时候，判断无环
        }
        //否则他们俩相遇且有环，这时候置其中的slow指针为head，再同时走，相遇点就是环起点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;//slow=fast时就是环起点
    }
}
