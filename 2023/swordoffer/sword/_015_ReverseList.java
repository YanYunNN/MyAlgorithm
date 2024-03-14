package com.yanyun.sword;

public class _015_ReverseList {
    /**
     * 反转链表
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * <p>
     * 三人行
     * pre  cur  next
     * A -> B -> C
     */
    public ListNode ReverseList0(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归
     */
    public ListNode ReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = ReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _015_ReverseList clazz = new _015_ReverseList();
        ListNode listNode = clazz.ReverseList0(head);
        System.out.println(listNode);
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




