package easy;

import java.util.LinkedList;
import java.util.Queue;

public class Q225_queueToStack {
    class MyStack {
        Queue<Integer> queue;

        public MyStack() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            int size = queue.size();
            while (size-- > 1) {
                queue.offer(queue.poll());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    class MyStack1 {
        Queue<Integer> queue;
        int top = 0;

        public MyStack1() {
            queue = new LinkedList<>();
        }

        public void push(int x) {
            queue.offer(x);
            top = x;
        }

        public int pop() {
            int size = queue.size();
            while (size > 2) {
                queue.offer(queue.poll());
                size--;
            }
            top = queue.peek();
            queue.offer(queue.poll());
            return queue.poll();
        }

        public int top() {
            return top;
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }

    class MyStack2 {
        Queue<Integer> queue1;
        Queue<Integer> queue2;

        public MyStack2() {
            queue1 = new LinkedList<>();
            queue2 = new LinkedList<>();
        }

        public void push(int x) {
            queue1.offer(x);
        }

        public int pop() {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            int top = queue1.poll();
            swap();
            return top;
        }

        public int top() {
            while (queue1.size() > 1) {
                queue2.offer(queue1.poll());
            }
            int top = queue1.poll();
            queue2.offer(top);
            swap();
            return top;
        }

        public boolean empty() {
            return queue1.isEmpty();
        }

        public void swap() {
            Queue<Integer> tmp;
            tmp = queue1;
            queue1 = queue2;
            queue2 = tmp;
        }
    }
}
