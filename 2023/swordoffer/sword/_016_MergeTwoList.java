package com.yanyun.sword;

public class _016_MergeTwoList {
    /**
     * 合并俩个单调有序链表,且结果有序
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * <p>
     * 新链表法
     */
    public ListNode Merge(ListNode p, ListNode q) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;
        while (p != null && q != null) {
            if (p.val <= q.val) {
                curr.next = p;
                p = p.next;
            } else {
                curr.next = q;
                q = q.next;
            }
            curr = curr.next;
        }
        //后续的节点
        curr.next = p == null ? q : p;
        return head.next;
    }

    /**
     * 递归法
     */
    public ListNode RecurseMerge(ListNode p, ListNode q) {
        if (p == null) return q;
        if (q == null) return p;
        if (p.val <= q.val) {
            p.next = RecurseMerge(p.next, q);
            return p;
        } else {
            q.next = RecurseMerge(p, q.next);
            return q;
        }
    }


    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _016_MergeTwoList clazz = new _016_MergeTwoList();
//        ListNode head = clazz.Merge(head1, head2);
//        System.out.println(head.list());
        ListNode recurseHead = clazz.RecurseMerge(head1, head2);
        System.out.println(recurseHead.list());
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

        public String list() {
            ListNode head = this;
            StringBuffer sb = new StringBuffer();
            sb.append("[");
            while (head != null) {
                sb.append(head.val);
                if (head.next != null) sb.append(",");
                head = head.next;
            }
            sb.append("]");
            return sb.toString();
        }
    }

    private static ListNode head1;
    private static ListNode head2;

    {
        head1 = new ListNode(1);
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(5);
    }

    {
        head2 = new ListNode(2);
        head2.next = new ListNode(4);
        head2.next.next = new ListNode(6);
        head2.next.next.next = new ListNode(7);
    }
}




