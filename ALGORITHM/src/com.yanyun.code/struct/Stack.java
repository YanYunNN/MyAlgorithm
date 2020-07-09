package com.yanyun.code.struct;

/**
 * @Auther: xcai
 * @Date: 2020/07/08/15:40
 * @Description:
 * @Version: 1.0
 */
public class Stack<T> {
    // 大小
    private int size;
    // 默认数据大小为4
    private Object[] array = new Object[4];

    // 非空判断函数
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public int size() {
        return size;
    }

    // 扩容函数
    public void expandCapacity() {
        Object[] newArray = new Object[size * 2];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }

    // 向栈内压元素
    public void push(T t) {
        array[size] = t;
        size++;
        if (size == array.length) {
            expandCapacity();
        }
    }

    // 弹出栈顶元素
    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            return null;
        } else {
            return (T) array[size - 1];
        }
    }

    // 移除栈顶元素
    public T pop() {
        if (isEmpty()) {
            return null;
        } else {
            T t = peek();
            //防止内存泄漏
            array[size - 1] = null;
            size--;
            return t;
        }
    }


}
