package com.yanyun.code;

/**
 * 链表结构
 */
public class LinkNode {
    public String data;
    public LinkNode next;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public LinkNode getNext() {
        return next;
    }

    public void setNext(LinkNode next) {
        this.next = next;
    }

    public LinkNode(String data, LinkNode next) {
        super();
        this.data = data;
        this.next = next;
    }

    public LinkNode() {
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
        LinkNode p = this;
        LinkNode q = new LinkNode();
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
