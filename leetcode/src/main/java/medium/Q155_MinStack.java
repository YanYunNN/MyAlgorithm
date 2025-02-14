package medium;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class Q155_MinStack {

    class Solution1 {
        class MinStack {

            // 数组栈, [当前值, 当前最小值]
            private Stack<int[]> stack = new Stack<>();

            public MinStack() {
            }

            public void push(int x) {
                if (stack.isEmpty()) {
                    stack.push(new int[]{x, x});
                } else {
                    stack.push(new int[]{x, Math.min(x, stack.peek()[1])});
                }
            }

            public void pop() {
                stack.pop();
            }

            public int top() {
                return stack.peek()[0];
            }

            public int getMin() {
                return stack.peek()[1];
            }
        }
    }

    class MinStack1 {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        public MinStack1() {
            stack = new LinkedList<>();
            minStack = new LinkedList<>();
            minStack.push(Integer.MAX_VALUE);
        }

        public void push(int val) {
            stack.push(val);
            minStack.push(val < minStack.peek() ? val : minStack.peek());
        }

        public void pop() {
            stack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)