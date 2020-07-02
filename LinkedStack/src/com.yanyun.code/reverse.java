package com.yanyun.code;

/**
 * 链表反转
 * 示例：
 * 输入：1->2->3->4->5->null
 * 输出：5->4->3->2->1->null
 */
public class reverse {

    public static void main(String[] args) {
        LinkNode linkList = new LinkNode("1", null);
        linkList.insert("2");
        linkList.insert("3");
        linkList.insert("4");
        linkList.insert("5");
        System.out.println(linkList);
        //注意LinkList是单例，反转是自身翻转
        LinkNode reverseList = recursiveReverseList(linkList);
        System.out.println(reverseList);

        LinkNode againReverseList = iteratorReverseList(reverseList);
        System.out.println(againReverseList);
    }

    public static LinkNode recursiveReverseList(LinkNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkNode newHead = recursiveReverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static LinkNode iteratorReverseList(LinkNode head) {
        LinkNode prev = null;
        LinkNode curr = head;
        while (curr != null) {
            LinkNode nxt = curr.next;
            curr.next = prev; // 翻转箭头
            prev = curr; //三人行
            curr = nxt; //三人行
        }
        return prev;
    }
}