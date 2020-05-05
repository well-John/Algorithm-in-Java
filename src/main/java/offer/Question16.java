package offer;

/**
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question16 {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double tmp = x;
        boolean flag = n > 0 ? true : false;
        n = Math.abs(n);
        while (n > 1) {
            x *= tmp;
            n--;
        }
        return flag ? x : 1 / x;
    }

    public static void main(String[] args) {
        Question16 question16 = new Question16();
        double v = question16.myPow(2.0000, -4);
        System.out.println(v);
    }
}