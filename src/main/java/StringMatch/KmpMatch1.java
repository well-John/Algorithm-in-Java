package StringMatch;

/**
 * 字符串匹配算法-kmp算法
 */
public class KmpMatch1 {

    private static void buildNext(int[] next, String p) {
        int j = 0; //下次开始找的位置
        int pLen = p.length();
        for (int i = 1; i < pLen; i++) {
            while (j > 0 && p.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }
            if (p.charAt(i) == p.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

    private static int kmpSearch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int j = 0;
        int[] next = new int[pLen];
        buildNext(next, p);
        for (int i = 0; i < sLen; i++) {
            while (j > 0 && s.charAt(i) != p.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            if (j == pLen) {
                return i - j + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = kmpSearch("abacbabab", "bab");
        System.out.println(index);
    }

}
