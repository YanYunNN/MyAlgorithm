package medium;

import base.ListNode;

/**
 * @ref Q143_reorderList
 */
public class Q148_linkedList_sort_list {
    public ListNode sortList(ListNode head) {
        //0.递归base case
        if (head == null || head.next == null)
            return head;
        //1.找到中点
        ListNode midNode = middleNode(head);

        //2.断链为2个子链表，并且递归归并
        ListNode tmp = midNode.next;
        midNode.next = null;

        //3.归并
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(tmp);

        //4.merge
        return mergeList(l1, l2);
    }

    //  找到链表中间节点（876. 链表的中间结点）
    private ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // fast和slow同一起点的话，对于节点数为偶数的链表，返回的是中间两个节点的第二个，无法正确拆分偶数链表。
        // 例如，一个链表只有1,2两个节点，如果fast,slow都=head，那么返回的中间节点是节点2，无法拆分。
        // 为了返回正确，需要让fast先走一步或两步
        // 是否让快指针从头节点的下一个节点开始，主要取决于你在链表长度为偶数时，希望慢指针停在哪个中点上
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // 合并两个有序链表（21. 合并两个有序链表）
    public ListNode mergeList(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode tmp = dummy, tmp1 = l1, tmp2 = l2; //因为是递归，所以不能改变l1，l2指针
        while (tmp1 != null && tmp2 != null) {
            if (tmp1.val < tmp2.val) {
                tmp.next = tmp1;
                tmp1 = tmp1.next;
            } else {
                tmp.next = tmp2;
                tmp2 = tmp2.next;
            }
            tmp = tmp.next;
        }
        tmp.next = tmp1 == null ? tmp2 : tmp1;
        return dummy.next;
    }
}
