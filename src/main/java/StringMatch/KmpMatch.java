package StringMatch;

/**
 * 字符串匹配算法-kmp算法
 */
public class KmpMatch {

    private static void buildNext(int[] next, String p) {
        next[0] = -1;
        int pLen = p.length();
        int k = -1, j = 0;
        while (j < pLen - 1) {
            if (k == -1 || p.charAt(k) == p.charAt(j)) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    private static int kmpSearch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        int i = 0, j = 0;
        int[] next = new int[pLen];
        buildNext(next, p);
        while (i < sLen && j < pLen) {
            if (j== -1|| s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }

        if (j == pLen) {
            return i - j;
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = kmpSearch("abacbabc", "cbab");
        System.out.println(index);
    }

}
