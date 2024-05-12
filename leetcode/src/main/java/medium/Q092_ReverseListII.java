package medium;

import base.ListNode;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/description/
 * 反转链表 between
 */
public class Q092_ReverseListII {
    //思路 头插
    //举例:0->1->[2->3->4->5]->6 假设此时prev位于7,cur位于2,next位于2,1234
    //       p   c  n
    //    0->1->[3->2->4->5]->6
    //    0->1->[4->3->2->5]->6
    //cur虽然没有动，但是next每次变成后面一个，结果也就是cur从区间头变成了尾巴，每次next头插，最终实现了局部反转
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;//头插法等场景适合使用虚拟节点
        ListNode prev = dummy;
        for (int i = 0; i < left - 1; i++) { //移动到第一个节点前面
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = 0; i < right - left; i++) { //反转r-l次，每次将后面一个节点头插入链表区间到头以实现反转
            ListNode next = cur.next;
            cur.next = next.next;  // 1->[2->4->5]->6  3->4..
            next.next = prev.next; // 1->[2->4->5]->6  3->2..
            prev.next = next;      // 1->[3->2->4->5]->6
        }
        return dummy.next;
    }

}
