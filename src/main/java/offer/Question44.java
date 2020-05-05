package offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question44 {

    public int findNthDigit(int n) {
        if (n <= 9) {
            return n;
        }
        long base = 9, count = 1;
        while (n > base * count) {
            n -= base * count;
            base *= 10;
            count++;
        }

        int number = (int) (Math.pow(10, count - 1) + n / count);
        if (n % count == 0) {
            number--;
        }
        int number_index = (int) ((n - 1) % count);

        return Integer.valueOf(String.valueOf(String.valueOf(number).charAt(number_index)));
    }

    public static void main(String[] args) {

       /* Question44 question44 = new Question44();
        int nthDigit = question44.findNthDigit(13);
        System.out.println(nthDigit);*/
       long i = (long)Integer.MAX_VALUE +1;
        System.out.println(i);
    }
}
