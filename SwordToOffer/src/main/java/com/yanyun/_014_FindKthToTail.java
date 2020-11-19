package com.yanyun;

import java.util.Stack;

public class _014_FindKthToTail {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * <p>
     * 暴力顺着数
     */
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        //先算出size
        int size = 0;
        ListNode cur = head;
        while (head != null) {
            head = head.next;
            size++;
        }
        if (k > size) return null;
        //顺着数第size-k个节点
        while ((size - k++) > 0) {
            cur = cur.next;
        }
        return cur;
    }

    public ListNode FindKthToTail1(ListNode head, int k) {
        if (head == null) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode node = null;
        while (k > 0 && k <= stack.size()) {
            node = stack.pop();
            k--;
        }
        return node;
    }

    /**
     * 快慢指针
     */
    public ListNode FindKthToTail2(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode fast = head, slow = head;
        //快指针先行
        while (k-- > 0) {
            if (fast != null) fast = fast.next;
            else return null;
        }
        //快慢同时走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 快慢指针2
     */
    public ListNode FindKthToTail3(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        ListNode fast = head, slow = head;
        //快指针先行
        int size = 0, a = k;
        while (fast != null) {
            fast = fast.next;
            if (k <= 0) {
                slow = slow.next;
            }
            a++;
            k--;
        }
        if (size < k) return null;
        return slow;
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _014_FindKthToTail clazz = new _014_FindKthToTail();
        System.out.println(clazz.FindKthToTail(head, 2).val);
    }

    /**
     * --------------------------------------------------INIT-----------------------------------------------------------
     */
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    private static ListNode head;

    {
        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
    }
}




