package com.yanyun.code.struct;

/**
 * @Auther: xcai
 * @Date: 2020/07/08/15:51
 * @Description:
 * @Version: 1.0
 */
public class ListNode<T> {
    T value;
    ListNode<T> next;

    public ListNode(T value, ListNode<T> next) {
        super();
        this.value = value;
        this.next = next;
    }
}
