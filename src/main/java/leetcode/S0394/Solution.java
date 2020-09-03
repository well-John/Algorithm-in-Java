package leetcode.S0394;

import java.util.Stack;

/**
 * 394 字符串解码
 * 输入：s = "3[a2[bc]]"
 * 输出："aaabcbc"
 */
public class Solution {


    public String decodeString(String s) {
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> charStack = new Stack<>();
        int i = 0;
        int time = 0;
        StringBuilder builder = new StringBuilder();
        while (i < s.length()) {
            while (Character.isDigit(s.charAt(i))) {
                time = time * 10 + getNumber(s.charAt(i));
                i++;
            }
            if (s.charAt(i) == '[') {
                numStack.add(time);
                time = 0;
                charStack.add(builder);
                builder = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                Integer pop = numStack.pop();
                StringBuilder newStr = charStack.pop();
                for (int j = 0; j < pop; j++) {
                    newStr.append(builder);
                }
                builder = newStr;
            } else {
                builder.append(s.charAt(i));
            }
            i++;
        }
        return builder.toString();
    }

    private int getNumber(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String decodeString = solution.decodeString("3[a2[bc]]");
        System.out.println(decodeString);

    }


}
