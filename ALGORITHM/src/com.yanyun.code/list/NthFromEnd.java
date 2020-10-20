package com.yanyun.code.list;

/**
 * @author xcai
 * @version 1.0
 * @date 2020/10/20/10:08
 * @description https://mp.weixin.qq.com/s/kKyghET5xmu4PoNPVWsSvQ
 * @item 如何找到链表的倒数第n个结点？
 * @tag 双指针/队列栈/遍历
 */
public class NthFromEnd {
    public static Node findNthFromEnd(Node head, int n) {
        Node p = head;
        Node q = head;
        //把q指针移动到正数第n个结点
        for (int i = 1; i < n; i++) {
            q = q.next;
            if (q == null) {
                throw new IllegalArgumentException("参数n超出链表长度！");
            }
        }
        while (q.next != null) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 9, 10};
        Node linkList = buildLinkList(array);
        Node nthFromEnd = findNthFromEnd(linkList, 3);
        System.out.println(nthFromEnd.data);

    }

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    //快速创建链表
    private static Node buildLinkList(int[] array) {
        Node head = new Node(array[0]);
        Node p = head;
        for (int i = 1; i < array.length; i++) {
            p.next = new Node(array[i]);
            p = p.next;
        }
        return head;
    }

}
