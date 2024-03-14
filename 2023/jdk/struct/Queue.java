package com.yanyun.code.struct;

/**
 * @Auther: xcai
 * @Date: 2020/07/08/15:49
 * @Description:
 * @Version: 1.0
 */
public class Queue<T> {
    private int size;
    private ListNode<T> head;
    private ListNode<T> last;

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public Queue(ListNode<T> head, ListNode<T> last) {
        super();
        //头尾相接，size为0
        head = new ListNode<>(null, null);
        last = head;
    }

    public void offer(T t) {
        ListNode<T> node = new ListNode<T>(t, null);
        //指向它
        last.next = node;
        //变成尾巴
        last = node;
        //别忘了数组长度++
        size++;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return head.next.value;
        }
    }

    public T poll() {
        if (isEmpty()) return null;
        else {
            ListNode<T> p = head.next;
            head.next = p.next;
            size--;
            if (size == 0) {
                last = head;
            }
            return p.value;
        }
    }

}

