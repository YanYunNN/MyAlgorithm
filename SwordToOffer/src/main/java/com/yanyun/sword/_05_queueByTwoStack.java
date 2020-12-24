package com.yanyun.sword;

import java.util.*;

public class _05_queueByTwoStack {
    /**
     * --------------------------------------------------SOLUTION-------------------------------------------------------
     * @description 栈1始终作队列入，每次出队列利用栈2颠倒，弹出后，又入栈1
     */
    public void push(int node) {
        stack1.push(node);
    }

    public int pop1() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        int pop = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        System.out.println(pop);
        return pop;
    }

    public int pop2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        System.out.println(stack2.peek());
        return stack2.pop();
    }

    /**
     * --------------------------------------------------MAIN-----------------------------------------------------------
     */
    public static void main(String[] args) {
        _05_queueByTwoStack queue = new _05_queueByTwoStack();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop1();
        queue.pop1();
        queue.push(4);
        queue.pop1();
        queue.pop1();

        queue.push(1);
        queue.push(2);
        queue.pop2();
        queue.push(3);
        queue.pop2();
        queue.push(4);
        queue.pop2();
        queue.pop2();
    }

    /**
     * --------------------------------------------------INIT-----------------------------------------------------------
     */
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
}




