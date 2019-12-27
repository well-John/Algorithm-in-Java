package leetcode.S020;

import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if (s == null || s.length() % 2 != 0) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.size() > 0) {
                    Character peek = stack.peek();

                    if (c == ')') {
                        if (peek == '(') {
                            stack.pop();
                        }
                    }

                    if (c == ']') {
                        if (peek == '[') {
                            stack.pop();
                        }
                    }

                    if (c == '}') {
                        if (peek == '{') {
                            stack.pop();
                        }
                    }
                } else {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        boolean valid = new Solution().isValid(")(");
        System.out.println(valid);

    }
}
