package easy;

import base.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q234_isPalindrome_linkedList {
    static class Solution_On {
        public boolean isPalindrome(ListNode head) {
            List<Integer> arr = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                arr.add(cur.val);
                cur = cur.next;
            }
            //双指针
            int p = 0, q = arr.size() - 1;
            while (p < q) {
                if (!arr.get(p).equals(arr.get(q))) return false;
                p++;q--;
            }
            return true;
        }
    }

    static class Solution_O1 {
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return true;
            }

            // 找到前半部分链表的尾节点并反转后半部分链表
            ListNode firstHalfEnd = endOfFirstHalf(head);
            ListNode secondHalfStart = reverseList(firstHalfEnd.next);

            // 判断是否回文
            ListNode p1 = head;
            ListNode p2 = secondHalfStart;
            boolean result = true;
            while (result && p2 != null) {
                if (p1.val != p2.val) {
                    result = false;
                }
                p1 = p1.next;
                p2 = p2.next;
            }

            // 还原链表并返回结果
            firstHalfEnd.next = reverseList(secondHalfStart);
            return result;
        }

        private ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = nextTemp;
            }
            return prev;
        }

        private ListNode endOfFirstHalf(ListNode head) {
            ListNode fast = head;
            ListNode slow = head;
            while (fast.next != null && fast.next.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            return slow;
        }
    }
}
