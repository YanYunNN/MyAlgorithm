package zhard;

import base.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * @author: xcai
 * @date: 2024/05/13
 * @desc k个问题：分治或者堆
 * @see <a href='https://leetcode.cn/problems/merge-k-sorted-lists/solutions/3787/leetcode-23-he-bing-kge-pai-xu-lian-biao-by-powcai'>Conf:分治、k个(小根堆)<a/>
 * @see easy.Q021_mergeTwoLists
 */
public class Q023_mergeKLists {
    public class solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            return merge(lists, 0, lists.length - 1);
        }

        public ListNode merge(ListNode[] lists, int left, int right) {
            if (left == right) return lists[left];
            int mid = left + (right - left) / 2;
            ListNode l1 = merge(lists, left, mid);
            ListNode l2 = merge(lists, mid + 1, right);
            return mergeTwoLists(l1, l2);
        }

        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                }
                cur = cur.next;
            }
            cur.next = l1 == null ? l2 : l1;
            return dummy.next;
        }
    }

    public class solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, Comparator.comparingInt(o -> o.val));//小根堆
            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            for (ListNode head : lists) {
                if (head != null) queue.add(head);             //头节点全部放入
            }
            while (!queue.isEmpty()) {
                ListNode node = queue.poll();
                if (node.next != null) queue.add(node.next);   //如果当前链表有后续，拿了一个出来就放一个进去
                cur.next = node;                               //先连接
                cur = cur.next;                                //再向后移动指针
            }
            return dummy.next;
        }
    }
}
