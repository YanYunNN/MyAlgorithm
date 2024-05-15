package medium;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q143_reorderList {
    public class Solution0 {
        public void reorderList(ListNode head) {
            if (head == null) return;
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            int i = 0, j = list.size() - 1;
            while (i < j) {
                list.get(i).next = list.get(j);
                i++;
                if (i == j) break;//到中间碰头了就结束
                list.get(j).next = list.get(i);
                j--;
            }
            //i==j时，需要有一个连接null,i/j都行因为相等了
            list.get(i).next = null;
        }
    }

    public class Solution1 {
        //[1,2,3,4,5]-> 1 5 2 4 3
        //1 2 3
        //5 4
        public void reorderList(ListNode head) {
            ListNode mid = middleNode(head);
            ListNode l1 = head;
            ListNode l2 = mid.next;
            mid.next = null; //拆分为俩个链表

            //反转 合并
            l2 = reverseList(l2);
            mergeList(l1, l2);
        }

        public void mergeList(ListNode l1, ListNode l2) {
            ListNode next1 = null;
            ListNode next2 = null;
            while (l1 != null && l2 != null) {
                next1 = l1.next;
                next2 = l2.next;

                l1.next = l2;
                l1 = next1;

                l2.next = l1;
                l2 = next2;
            }
        }

        public ListNode middleNode(ListNode head) {
            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;
            ListNode prev = null, cur = head, next = null;
            while (cur != null) {
                next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;
        }
    }
}
