package leetcode.S008;

/**
 * 请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
 * <p>
 * 函数myAtoi(string s) 的算法如下：
 * <p>
 * 读入字符串并丢弃无用的前导空格
 * 检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
 * 读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
 * 将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
 * 如果整数数超过 32 位有符号整数范围 [−231, 231− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231− 1 的整数应该被固定为 231− 1 。
 * 返回整数作为最终结果。
 * <p>
 * 本题中的空白字符只包括空格字符 ' ' 。
 * 除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
 */
public class Solution {

    public int myAtoi(String s) {

        int flag = 1;
        int i = 0;
        int length = s.length();
        while (i < length && s.charAt(i) == ' ') {
            i++;
        }
        if (i >= length) {
            return 0;
        }

        if (s.charAt(i) != '+' && s.charAt(i) != '-' && !Character.isDigit(s.charAt(i))) {
            return 0;
        }

        if (s.charAt(i) == '-') {
            flag = 0;
            i++;
        } else if (s.charAt(i) == '+') {
            i++;
        }
        if (i >= length) {
            return 0;
        }

        if (!Character.isDigit(s.charAt(i))) {
            return 0;
        }

        int size = 0;
        long val = 0;
        while (i < length && Character.isDigit(s.charAt(i))) {
            int value = s.charAt(i) - '0';
            if (value != 0 || size != 0) {
                if (flag == 1) {
                    val = val * 10 + value;
                } else {
                    val = val * 10 - value;
                }
                if (val >= Integer.MAX_VALUE) {
                    val = Integer.MAX_VALUE;
                    break;
                }

                if (val <= Integer.MIN_VALUE) {
                    val = Integer.MIN_VALUE;
                    break;
                }
                size++;
            }
            i++;
        }
        return (int) val;
    }


    public static void main(String[] args) {
        int atoi = new Solution().myAtoi("91283472332");
        System.out.println(atoi);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);

    }
}
