package com.yanyun;

public class _015_ReverseList {
    /**
     * 输入一个链表，输出该链表中倒数第k个结点。
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * <p>
     * 暴力顺着数
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
     * 暴力顺着数
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




