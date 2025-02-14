package easy;

import java.util.Stack;

public class Q1047_removeDuplicates {

    Stack<Character> stack = new Stack<>();

    public String removeDuplicates(String s) {
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
