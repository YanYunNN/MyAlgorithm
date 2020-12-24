package com.yanyun.sword;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class _03_printLinkedList {
    //非递归（翻转）
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        Collections.reverse(list);
        System.out.println(list.toString());
        return list;
    }

    //非递归（add(index,E)）
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(0, listNode.val);
            listNode = listNode.next;
        }
        System.out.println(list.toString());
        return list;
    }

    //递归（系统栈）
    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead2(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    //栈
    public ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
        return list;
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _03_printLinkedList linkedList = new _03_printLinkedList();
        linkedList.printListFromTailToHead(head);
        linkedList.printListFromTailToHead1(head);
        System.out.println(linkedList.printListFromTailToHead2(head).toString());
        System.out.println(linkedList.printListFromTailToHead3(head).toString());
    }

    /**
     * --------------------------------------------------INIT-----------------------------------------------------------
     */
    private static ListNode head;

    {
        head = new ListNode(67);
        head.next = new ListNode(0);
        head.next.next = new ListNode(24);
        head.next.next.next = new ListNode(58);
    }

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}




