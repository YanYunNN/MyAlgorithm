package medium;

import base.ListNode;

import java.util.HashSet;
import java.util.Set;

public class Q082_linkedList_delDuplicates {
    //[1,2,3,3,4,4,5]->[1,2,5]
    //由于链表已经是排好序的，因此，一次遍历即可，且头节点可能被删除
    public ListNode deleteDuplicates2(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        //12334->cur=2,cur.next=4这样就删除了重复节点，因此关键是找到4，让cur.next=4
        while (cur.next != null && cur.next.next != null) {
            int val = cur.next.val;
            if (cur.next.next.val == val) {
                while (cur.next != null && cur.next.val == val) {//找到下一个不等于重复val的节点
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

    //[1,2,3,3,4,4,5]->[1,2,3,4,5]
    public ListNode deleteDuplicates1(ListNode head) {
        if (head == null) return null;
        Set<Integer> set = new HashSet<>();
        ListNode cur = head, prev = null;
        while (cur != null) {
            if (!set.contains(cur.val)) {
                set.add(cur.val);
                prev = cur;
                cur = cur.next;
            } else {
                prev.next = cur.next;
                cur = prev.next;
            }
        }
        return head;
    }
}
