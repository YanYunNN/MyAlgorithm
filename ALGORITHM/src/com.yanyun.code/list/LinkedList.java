package com.yanyun.code.list;

/**
 * 链表结构
 */
public class LinkedList {
    public String data;
    public LinkedList next;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LinkedList getNext() {
        return next;
    }

    public void setNext(LinkedList next) {
        this.next = next;
    }

    public LinkedList(String data, LinkedList next) {
        super();
        this.data = data;
        this.next = next;
    }

    public LinkedList() {
        super();
    }

    @Override
    public String toString() {
        return data + " -> " + next;
    }

    /**
     * 尾插
     * @param data
     */
    public void insert(String data) {
        LinkedList p = this;
        LinkedList q = new LinkedList();
        for (int i = 0; ; ) {
            if (p.next == null) {
                q.setData(data);
                q.setNext(null);
                p.setNext(q);
                break;
            } else {
                p = p.next;
            }
        }
    }
}
