package easy;

import base.ListNode;

/**
 * 相交链表的起始节点
 * @author: xcai
 * @date: 2024/05/14
 * @see <a href=''>Conf<a/>
 */
public class Q160_intersectionOfTwoLinkedlists {
    //H1:    a1 a2 c1 c2
    //H2: b1 b2 b3 c1 c2
    //L1: a1 a2 c1 c2 b1 b2 b3 c1 ..
    //L2: b1 b2 b3 c1 c2 a1 a2 c1 ..
    //while（l1=l2）
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1 == null ? headB : l1.next; //指向另一个链表头
            l2 = l2 == null ? headA : l2.next; //指向另一个链表头
        }
        return l1;
    }
}
