package offer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，
 * 该函数将返回左旋转两位得到的结果"cdefgab"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Question58 {

    public static String reverseLeftWords(String s, int n) {
        return s.substring(n).concat(s.substring(0, n));
    }

    public static String reverseLeftWords2(String s, int n) {
        char[] chars = s.toCharArray();
        char[] newChar = new char[chars.length];
        int k = 0;
        for (int i = n; i < chars.length; i++) {
            newChar[k++] = chars[i];
        }

        for (int i = 0; i < n; i++) {
            newChar[k++] = chars[i];
        }
        return String.valueOf(newChar);
    }

    public static void main(String[] args) {

        String words = reverseLeftWords2("lrloseumgh", 6);
        System.out.println(words);
    }
}
